package demo.reflect;

import java.lang.reflect.Constructor;

public class ConstructDemo {

	public static void main(String[] args) {
		Class c = String.class;

		Constructor[] constructors = c.getConstructors();// 本类中不限制修饰符的属性
		for (Constructor item : constructors) {
			Class<?>[] types = item.getParameterTypes();
			String name = item.getName();
			int modify = item.getModifiers(); // 修饰符
			System.out.print(modify + " " + name + "(");
			for (Class<?> paramsType : types) {
				System.out.print(paramsType.getName() + ",");
			}
			System.out.println(")");
		}
	}
}
