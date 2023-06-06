package com.simeio.autowiring;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext("com.simeio.autowiring");
		Arrays.stream(context.getBeanDefinitionNames()).forEach((bean) -> System.out.println(bean));

		ShapeFactory factory = context.getBean("shapeFactory", ShapeFactory.class);
		factory.printArea("r", 10, 20);

		/*
		 * ShapeFactory shapeFactory = new ShapeFactory();
		 * shapeFactory.printArea("Square", 5, 5); shapeFactory.printArea("Rectangle",
		 * 5, 10); shapeFactory.printArea("Triangle", 5, 8);
		 */

		NewShapeFactory newShapeFactory = (NewShapeFactory) context.getBean("newShapeFactory", NewShapeFactory.class);
		newShapeFactory.printArea("square", 2, 2);
		newShapeFactory.printArea("rectangle", 5, 5);
		newShapeFactory.printArea("triangle", 4, 6);
	}

}
