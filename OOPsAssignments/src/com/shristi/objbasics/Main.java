package com.shristi.objbasics;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of students : ");
		int count = sc.nextInt();
		sc.nextLine();

		while (count > 0) {

			System.out.println("Enter Student Name : ");
			String name = sc.nextLine();
			System.out.println("Enter Student Id : ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Student Marks for 5 subjects: ");
			int[] marks = new int[5];
			for (int i = 0; i < marks.length; i++) {
				marks[i] = sc.nextInt();
			}
			sc.nextLine();

			Student student = new Student(name, id);
			student.printDetails();
			System.out.println("Grade - " + student.getGrades(marks));

			count--;
		}
		sc.close();

	}

}
