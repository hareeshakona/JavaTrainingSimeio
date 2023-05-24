package com.simeio.basic;

import java.util.Scanner;

public class ScanDemo {

	public static void main(String[] args) {
		System.out.println("Enter details");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Welcome "+name);
		System.out.println("Enter age");
		int age = sc.nextInt();
		System.out.println("Age "+age);
		System.out.println("Enter city");
		sc.nextLine();
		String city = sc.nextLine();
		System.out.println("City "+city);
		System.out.println("Enter Salary");
		double salary = sc.nextDouble();
		System.out.println("Salary "+salary);	
		sc.close();

	}

}
