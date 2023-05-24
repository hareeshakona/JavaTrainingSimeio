package com.simeio.langbasics;

import java.util.Objects;

public class Employee {

	private String empName;
	private String city;
	private int employeeId;
	private String department;

	public Employee() {
		super();

	}

	public Employee(String empName, String city, int employeeId, String department) {
		super();
		this.empName = empName;
		this.city = city;
		this.employeeId = employeeId;
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, department, empName, employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department)
				&& Objects.equals(empName, other.empName) && employeeId == other.employeeId;
	}

	
}
