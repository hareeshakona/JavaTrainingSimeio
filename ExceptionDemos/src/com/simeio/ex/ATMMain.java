package com.simeio.ex;

public class ATMMain {

	public static void main(String[] args) {
		
		System.out.println("In ATM");
		Bank bank = new Bank();
		try {
			bank.withdraw(1000);
			System.out.println("Amount withdrawn successful");
		} catch (Exception e) {
			System.out.println("System error");
			e.printStackTrace();
		}
		
		System.out.println("Try again");
	}
}
