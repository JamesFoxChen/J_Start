package test.java;

import org.junit.Test;

import utils.HttpUtil;

public class HttpTest {

	@Test
	public void Get() {
		String result=HttpUtil.Get("http://www.baidu.com");
		System.out.println(result);
	}

	
	@Test
	public void Post() {
	
	}
}
