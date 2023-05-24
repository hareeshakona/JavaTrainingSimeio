package com.shristi.basic;

import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {

		String[] usernames = { "Rahul", "Roshan", "Sarah", "Cindy", "John", "Mark", "Anjali", "Naveen" };

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to register :");
		String name = sc.nextLine();
		boolean found = false;

		for (String username : usernames) {
			if (username.equalsIgnoreCase(name)) {
				found = true;
				break;
			}
		}
		if (found == true)
			System.out.println("Name is not unique.");
		else
			System.out.println("You are registered.");
		
		sc.close();

	}

}
