package test;

import java.util.ArrayList;

import org.junit.Test;

import bean.Student;
import utils.JsonUtil;

public class JsonTest {

	@Test
	public void JsonToEntity() {
		String str = "{id:'1001',name:'张三',age:'22'}";
		Student student = JsonUtil.JsonToEntity(str, Student.class);
		System.out.println(student);
		int i = 0;
	}

	@Test
	public void JsonToEntityList() {
		String str = "[{id:'1001',name:'张三',age:'22'},{id:'李四',name:'张三',age:'23'}]";
		ArrayList<Student> student = JsonUtil.JsonToEntityList(str, Student.class);
		System.out.println(student);
		int i = 0;
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

	@Test
	public void EntityToStringGeneric() {
		Student s = new Student();
		s.setAge(25);
		s.setId(12);
		s.setName("JamesC");

		String str = JsonUtil.EntityToStringGeneric(s);
	}

	@Test
	public void EntityToStringGenericList() {
		ArrayList<Student> aList = new ArrayList<Student>();
		Student s = new Student();
		s.setAge(25);
		s.setId(12);
		s.setName("JamesC");
		aList.add(s);

		s = new Student();
		s.setAge(26);
		s.setId(13);
		s.setName("JamesD");
		aList.add(s);

		String str = JsonUtil.EntityToStringGenericList(aList);
	}
}
