package test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.junit.Test;

public class ConfigTest {

	@Test
	public void test() {
		Properties prop = new Properties();
		String propName="config.properties";
		
		try {
			// 读取属性文件a.properties
			InputStream in = new BufferedInputStream(new FileInputStream(propName));
			prop.load(in); // /加载属性列表
			/*
			 * Iterator<String> it=prop.stringPropertyNames().iterator();
			 * while(it.hasNext()){ String key=it.next();
			 * System.out.println(key+":"+prop.getProperty(key)); }
			 */
			String userName = prop.getProperty("username");
			in.close();
			
			System.out.println(userName);

			// /保存属性到新的config.properties文件
			FileOutputStream oFile = new FileOutputStream(propName, true);// true表示追加打开
			prop.setProperty("username", "admin123");
			prop.store(oFile, "The New properties file");
			oFile.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
