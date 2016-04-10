package demo.reflect;

import java.lang.reflect.Field;

public class FieldDemo {

	public static void main(String[] args) {
		Class c = String.class;

		//getFields()获得某个类的所有的公共（public）的字段，包括父类。 
		//getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，
		//但是不包括父类的申明字段。 

		Field[] fields = c.getDeclaredFields();// 本类中不限制修饰符的属性
		for (Field item : fields) {
			Class fieldType = item.getType();
			String typeName = fieldType.getName();
			String fieldName = item.getName();
			System.out.println(typeName + ":" + fieldName);
		}
	}
}
