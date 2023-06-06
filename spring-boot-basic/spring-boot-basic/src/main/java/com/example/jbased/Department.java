package com.example.jbased;

import org.springframework.beans.factory.annotation.Value;


public class Department {

	private String deptName;
	private String deptHead;

	public String getDeptName() {
		return deptName;
	}

	@Value("${student.department.name}")
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	@Value("${student.department.head}")
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}
	
	

}
