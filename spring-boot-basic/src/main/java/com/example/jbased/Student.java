package com.example.jbased;

import org.springframework.beans.factory.annotation.Value;


public class Student {

	private String name;
	
	private Department department;
	
	

	public Student(Department department) {
		super();
		this.department = department;
	}


	public String getName() {
		return name;
	}

	
	@Value("${student.name}")
	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}
	
	//@Autowired
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", department=" + department + "]";
	}

}
