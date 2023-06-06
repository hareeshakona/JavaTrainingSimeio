package com.example.jbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//class that has details about all the spring beans
@Configuration
public class AppConfig {
	
	//create a method for a bean that returns the object
	//this is a bean definition
	@Bean
	public Student getStudent() {
		return new Student(getDepartment());
	}
	
	//@Bean
	public Department getDepartment() {
		return new Department();
	}
	
}
