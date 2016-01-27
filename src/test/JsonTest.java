package test;

import org.junit.Test;

import Utils.JsonUtil;
import bean.Student;

public class JsonTest {

	@Test
	public void StringToBeanT() {
		String str = "{id:'1001',name:'张三',age:'22'}";
		Student student = JsonUtil.JsonToEntity(str, Student.class);
		
		int i=0;
	}

	@Test
	public void StringToBean() {
		// String str =
		// "{\"CityId\": 18,\"CityName\": \"西安\",\"ProvinceId\": 27,\"ProvinceName\": \"陕西\"}";
		String str = "{id:'1001',name:'张三',age:'22'}";
		JsonUtil.JsonToEntity(str);
	}

	@Test
	public void EntityToString() {
		Student s = new Student();
		s.setAge(19);
		s.setId(11);
		s.setName("James");

		JsonUtil.EntityToString(s);
	}
}
