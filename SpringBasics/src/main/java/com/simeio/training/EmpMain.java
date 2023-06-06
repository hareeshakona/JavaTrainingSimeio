package com.simeio.training;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		
		//create an object of IOC container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.simeio");
		Arrays.stream(context.getBeanDefinitionNames()).forEach((bean)-> System.out.println(bean));
		
		Employee employee = (Employee)context.getBean("employee");
		System.out.println(employee);
		Employee employee1 = context.getBean("employee",Employee.class);
		System.out.println(employee1);
		Employee employee2 = context.getBean(Employee.class);
		System.out.println(employee2);
		
		((AbstractApplicationContext)context).close();

		/*Employee employee = new Employee();
		
		Address address = new Address();
		address.setCity("Bangalore");
		address.setState("Karnataka");
		
		employee.setEmployeeId(1);
		employee.setName("Kishan");
		employee.setAddress(address);
		
		System.out.println(employee);*/

	}

}
