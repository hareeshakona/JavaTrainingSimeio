package com.shristi.inherdemos;

public class Current extends Account {
	
	public Current(double balance) {
		super(balance);
	}

	void withdraw(double amount) {

		if (balance >= amount) {
			balance = balance - amount;
			System.out.println("Withdrawing amount from Current Account : " + amount);
			System.out.println("Please collect your money and collect the card");
		} else {
			System.out.println("Sorry! Insufficient funds in Current Account");
		}

		System.out.println("Your Current Account balance is " + balance);
	}

	void deposit(double amount) {

		System.out.println("Depositing amount : " + amount);
		balance = balance + amount;
		System.out.println("Your money has been successfully deposited");
		System.out.println("Your Current Account balance is " + balance);

	}

}
