package com.shristi.basic;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {

		String[] usernames = { "Rahul", "Roshan", "Sarah", "Cindy", "John", "Mark Antony", "Anjali", "Naveen" };

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username to login :");
		String name = sc.nextLine();
		boolean found = false;

		for (String username : usernames) {
			if (username.equalsIgnoreCase(name)) {
				found = true;
				break;
			}
		}
		if (found == true)
			System.out.println("You are logged in successfully.");
		else
			System.out.println("Invalid username.");

		sc.close();

	}

}
