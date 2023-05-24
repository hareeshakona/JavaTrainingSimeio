package com.oops.inheritance;

public class InEmployee {
	
	private String name;
	private double salary;
	private String city;
	
	public InEmployee(String name, double salary, String city) {
		super();
		this.name = name;
		this.setSalary(salary);
		this.setCity(city);
	}
	
	void calcBonus(double amount) {}
	void print() {
		System.out.println("Hello "+name);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
