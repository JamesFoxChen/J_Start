package test;
import javax.lang.model.element.VariableElement;

import Utils.HttpUtil;
import org.junit.Test;

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
