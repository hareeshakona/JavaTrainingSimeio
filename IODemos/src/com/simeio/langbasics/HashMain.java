package com.simeio.langbasics;

public class HashMain {
	
	public static void main(String[] args) {
		Employee employee1 = new Employee("Ram", "Ban", 1, "Admin");
		Employee employee2 = new Employee("Raghav", "Ban", 2, "Admin");
		Employee employee3 = new Employee("Ram", "Ban", 1, "Admin");
		Employee employee4 = new Employee("Jo", "Chennai", 1, "Dev");
		Employee employee5 = employee4;
		
		System.out.println("4 vs 5"+employee4.equals(employee5));
		System.out.println("4 vs 5"+(employee4 == employee5));
		
		System.out.println("1 vs 2"+employee1.equals(employee2));
		System.out.println("1 vs 3"+employee1.equals(employee3));
		System.out.println("1 vs 4"+employee1.equals(employee4));
		
		System.out.println("1 "+employee1.hashCode());
		System.out.println("2 "+employee2.hashCode());
		System.out.println("3 "+employee3.hashCode());
		System.out.println("4 "+employee4.hashCode());
	}

}
