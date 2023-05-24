package com.simeio.custom;

public class ATMDemo {

	public static void main(String[] args) {
		
		System.out.println("In ATM");
		ABCBank bank = new ABCBank();
		try {
			bank.withdraw(3000);
			System.out.println("Amount withdrawn successful");
		} catch (Exception e) {
			System.out.println("System error");
			e.printStackTrace();
		}
		
		System.out.println("Try again");
	}
}
