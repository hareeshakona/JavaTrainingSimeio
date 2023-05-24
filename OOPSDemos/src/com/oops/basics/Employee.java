package com.oops.basics;

public class Employee {
	
	String name;
	double salary;
	
	Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	void getDetails() {
		System.out.println("name "+name);
		System.out.println("salary "+salary);
	}
	
	String greet(String msg) {
		return "welcome "+msg;
	}


}
