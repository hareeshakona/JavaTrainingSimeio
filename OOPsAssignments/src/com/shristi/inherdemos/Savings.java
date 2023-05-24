package com.shristi.inherdemos;

public class Savings extends Account {

	public Savings(double balance) {
		super(balance);
	}

	void withdraw(double amount) {

		if (balance >= amount) {
			balance = balance - amount;
			System.out.println("Withdrawing amount from Savings Account : " + amount);
			System.out.println("Please collect your money and card");
		} else {
			System.out.println("Sorry! Insufficient funds in Savings Account");
		}

		System.out.println("Your Savings Account balance is " + balance);
	}

	void deposit(double amount) {

		System.out.println("Depositing amount : " + amount);
		balance = balance + amount;
		System.out.println("Your money has been successfully deposited");
		System.out.println("Your Savings Account balance is " + balance);

	}

}
