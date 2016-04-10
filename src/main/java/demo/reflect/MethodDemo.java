package demo.reflect;

import java.lang.reflect.Method;

public class MethodDemo {

	public static void main(String[] args) {
		A a = new A();
		Class c = a.getClass();

		try {
			Method p1 = c.getMethod("print"); // 获取父类和本类的公共方法
			p1.invoke(a);

			Method p2 = c.getMethod("print", int.class, int.class);
			p2.invoke(a, 10, 20);
			
			Method p3=c.getMethod("print",new Class[]{String.class,String.class,String.class});
			p3.invoke(a,"11","22","33");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Class cs = String.class;
		Method[] methods = cs.getDeclaredMethods();//本类和父类的公共方法
		for (Method item : methods) {
			Class<?>[] methodType = item.getParameterTypes();
			String name = item.getName();
			Class returnType=item.getReturnType();
			int modify=item.getModifiers();  //修饰符
			System.out.print(modify+" "+returnType.getName()
								+" "+name+"(");
			for(Class<?> paramsType:methodType)
			{
				System.out.print(paramsType.getName()+",");
			}
			System.out.println(")");
		}
	}
}

class A {
	public void print() {
		System.out.println("print()");
	}

	public void print(int a, int b) {
		System.out.println("print(int a,int b)" + " a:" + a + " b:" + b);
	}

	public void print(String a, String b, String c) {
		System.out.println("print(String a,String b,String c)" + " a:" + a + " b:" + b+ " c:" + c);
	}
}