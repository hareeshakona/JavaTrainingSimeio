package com.shristi.inherdemos;

import java.util.Scanner;

public class ATMMain {

	static Scanner sc = new Scanner(System.in);
	static Account savings = new Savings(500000);
	static Account current = new Current(100000);

	static Account getUserAccount() {

		// Account selectedaccount = null;
		// Scanner scanner = new Scanner(System.in);

		System.out.println("Please select an account : \n 1 - Savings\n 2 - Current");
		int account = sc.nextInt();
		sc.nextLine();

		while (account != 1 & account != 2) {
			System.out.println("Invalid option. Please choose the correct option.");
			account = sc.nextInt();
			sc.nextLine();
		}

		if (account == 1) {
			return savings;
		} else {
			return current;
		}

		// sc.close();
		// return selectedaccount;

	}

	public static void main(String[] args) {

		while (true) {

			// Scanner sc = new Scanner(System.in);

			System.out.println("Automated Teller Machine");
			System.out
					.println("Please select an option : \n 1 - Withdraw\n 2 - Deposit\n 3 - Check Balance\n 4 - Exit");

			int option = sc.nextInt();
			sc.nextLine();

			while (option < 1 || option > 4) {
				System.out.println("Invalid option. Please choose the correct option.");
				option = sc.nextInt();
				sc.nextLine();
			}

			// int account = 0;
			double amount = 0;
			Account useraccount = null;

			switch (option) {
			case 1: {
				useraccount = getUserAccount();
				System.out.println("Enter amount to withdraw");
				amount = sc.nextDouble();
				sc.nextLine();

				useraccount.withdraw(amount);
				break;

			}
			case 2: {
				useraccount = getUserAccount();
				System.out.println("Enter amount to deposit");
				amount = sc.nextDouble();
				sc.nextLine();

				useraccount.deposit(amount);
				break;
			}
			case 3: {
				useraccount = getUserAccount();
				amount = useraccount.getBalance();
				System.out.println("Your balance is " + amount);
				break;
			}
			case 4: {
				// sc.close();
				System.exit(0);
			}
			}

		}

	}

}
