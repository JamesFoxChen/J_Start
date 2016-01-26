package AnnotationDemo;

import java.io.IOException;

@Desciption(auth = "James", desc = "About Love", age = 18)
public class DescBean {

	public void OutputAnnotation() {
		Class c = this.getClass();
		boolean b = c.isAnnotationPresent(Desciption.class);
		if (!b) {
			return;
		}

		Desciption desciption = (Desciption) c.getAnnotation(Desciption.class);
		System.out.println(desciption.auth());
		System.out.println(desciption.age());
		System.out.println(desciption.desc());
	}
}
