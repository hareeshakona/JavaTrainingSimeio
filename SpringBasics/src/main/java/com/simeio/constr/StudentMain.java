package com.simeio.constr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.simeio");
		
		Student student = context.getBean("student",Student.class);
		System.out.println(student);
		
		((AbstractApplicationContext )context).close();
		
		
		

	}

}
