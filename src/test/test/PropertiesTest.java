package test;

import org.junit.Test;

import utils.DateTimeUtil;
import utils.PropertiesUtil;

public class PropertiesTest {

	private final String configName="config.properties";
	
	@Test
	public void Read() {
		PropertiesUtil util=new PropertiesUtil(this.configName);
		String str=util.readValue("username");
		System.err.println(str);
	}
	

	@Test
	public void Update() {
		PropertiesUtil util=new PropertiesUtil(this.configName);
		util.setValue("username","James:"+DateTimeUtil.GetCurrentTime());
		String str=util.readValue("username");
		
		System.err.println(str);
	}
	
	@Test
	public void add() {
		PropertiesUtil util=new PropertiesUtil(this.configName);
		util.setValue("age","20");
		String str=util.readValue("age");
		
		System.err.println(str);
	}
}
