package com.shristi.overloading;

import java.util.Scanner;

public class OverloadMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of employees :");
		int count = sc.nextInt();
		sc.nextLine();

		while (count > 0) {
			System.out.println("Enter Employee name :");
			String name = sc.nextLine();
			System.out
					.println("Enter Employee designation :\n" + "1 - Director \n" + "2 - Manager\n" + "3 - Programmer");
			int selected = sc.nextInt();
			sc.nextLine();
			while (selected < 1 || selected > 3) {
				System.out.println("Enter the correct designation.");
				selected = sc.nextInt();
				sc.nextLine();
			}
			String designation = null;
			switch (selected) {
			case 1:
				designation = "Director";
				break;
			case 2:
				designation = "Manager";
				break;
			case 3:
				designation = "Programmer";
			}

			Employee employee = new Employee(name, designation);

			if (employee.designation.equals("Programmer"))
				System.out.println("Bonus is - " + employee.calcBonus(10000));
			else if (employee.designation.equals("Manager"))
				System.out.println("Bonus is - " + employee.calcBonus(15000, 5000));
			else
				System.out.println("Bonus is - " + employee.calcBonus(20000, 10000, 15000));

			count--;

		}
		sc.close();

	}

}
