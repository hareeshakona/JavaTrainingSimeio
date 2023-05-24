package com.oops.basics;

public class EmpDemo {

	public static void main(String[] args) {

		Employee employee1 = new Employee("Ram",1000);
		employee1.getDetails();
		String v = employee1.greet("back");
		System.out.println(v);
		
		/*employee1.name = "Ram";
		employee1.salary = 1000;*/

		//System.out.println(employee1.name + " " + employee1.salary);

		/*Employee employee2 = new Employee();
		employee2.name = "John";
		employee2.salary = 2000;
		employee2.getDetails();
		System.out.println(employee2.greet("back"));*/
		//System.out.println(employee2.name + " " + employee2.salary);

	}

}
