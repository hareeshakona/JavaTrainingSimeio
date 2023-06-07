package com.training;

import com.opencsv.bean.CsvBindByPosition;

public class Employee {

	@CsvBindByPosition(position=0)
	private String employeeName;
	@CsvBindByPosition(position=1)
	private int employeeId;
	@CsvBindByPosition(position=2)
	private double salary;
	@CsvBindByPosition(position=3)
	private String city;
	@CsvBindByPosition(position=4)
	private String designation;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId=" + employeeId + ", salary=" + salary
				+ ", city=" + city + ", designation=" + designation + "]";
	}
	


	
	
	

}
