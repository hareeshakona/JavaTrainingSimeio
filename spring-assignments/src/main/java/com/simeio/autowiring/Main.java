package com.simeio.autowiring;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.simeio.autowiring");
		Arrays.stream(context.getBeanDefinitionNames()).forEach((bean) -> System.out.println(bean));
		
		Performer performer = (Performer)context.getBean("performer",Performer.class);
		performer.playSong("violin", "Beleiver");
		performer.playSong("guitar", "Butter");
		performer.playSong("keyboard", "Calm Down");
		
		((AbstractApplicationContext)context).close();

	}

}
