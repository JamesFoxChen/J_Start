package utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {

	// "config.properties"
	private String configPath = null;

	private Properties props = null;

	public PropertiesUtil(String propertyName) {
		this.configPath = propertyName;
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(this.configPath);
		props = new Properties();
		try {
			props.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String readValue(String key) {
        props = new Properties();   
        try {   
        	InputStream in = this.getClass().getClassLoader().getResourceAsStream(this.configPath);  
            props.load(in);   
            String value = props.getProperty(key);   
            //System.out.println(key +"键的值是："+ value);   
            return value;   
        } catch (Exception e) {   
            e.printStackTrace();   
            return null;   
        }   
	}

	public Map<String, String> readAllProperties() {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration en = props.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String Property = props.getProperty(key);
			map.put(key, Property);
		}
		return map;
	}

	public void updateValue(String key, String value) {
		try {
			props.load(new FileInputStream(this.configPath));

			OutputStream fos = new FileOutputStream(this.configPath);
			props.setProperty(key, value);

			props.store(fos, "Update '" + key + "' value");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void setValue(String key, String value) {

		OutputStream fos;
		try {
			fos = new FileOutputStream(this.configPath);
			props.setProperty(key, value);
			try {
				props.store(fos, "Update '" + value + "' value");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// //props.setProperty(key,value);
		// Properties prop = new Properties();
		// InputStream fis = new FileInputStream(this.configPath);
		// // ���������ж�ȡ�����б�����Ԫ�ضԣ�
		// prop.load(fis);
		// // ���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�
		// // ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
		// OutputStream fos = new FileOutputStream(this.configPath);
		// prop.setProperty(key, value);
		// // ���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��
		// // ���� Properties ���е������б�����Ԫ�ضԣ�д�������
		// prop.store(fos, "last update");
		// //�ر��ļ�
		// fis.close();
		// fos.close();
	}
}
