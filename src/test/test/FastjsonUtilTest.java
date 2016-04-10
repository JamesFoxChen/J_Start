package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import bean.Person;
import utils.FastjsonUtil;

public class FastjsonUtilTest {
	@Test
	public void StringToEntity() {
		// {"age":20,"name":"Rollen"}
		// [{"age":20,"name":"Rollen"},{"age":30,"name":"Rollen2"}]

		String str = "{\"age\":20,\"name\":\"Rollen\"}";
		Person person = FastjsonUtil.StringToEntity(str, Person.class);
		System.out.println(ReflectionToStringBuilder.toString(person));
	}

	@Test
	public void StringToEntityList() {
		String str = "[{\"age\":20,\"name\":\"Rollen\"},{\"age\":30,\"name\":\"Rollen2\"}]";
		List<Person> person = FastjsonUtil.StringToEntityList(str, Person.class);
		
		System.out.println(person.size());
		for (Person person2 : person) {
			System.out.println(ReflectionToStringBuilder.toString(person2));
		}
	}

	@Test
	public void EntityToString() {
		Person p = new Person();
		p.setName("Rollen");
		p.setAge(20);

		String entityStr = FastjsonUtil.EntityToString(p);
		System.out.println(entityStr);

		List<Person> list = new ArrayList<Person>();
		list.add(p);

		p = new Person();
		p.setName("Rollen2");
		p.setAge(30);
		list.add(p);

		entityStr = FastjsonUtil.EntityToString(list);
		System.out.println(entityStr);
	}
}