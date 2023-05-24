package com.simeio.ex;

public class Bank {

	int balance = 2000;

	void withdraw(double amount) throws Exception {
		System.out.println("In Bank");
		try {
			if(amount > 1000) {
				throw new Exception();
			}
			balance -= amount;
			int x = balance / 0;
			System.out.println("Balance deducted");
			

		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println("Technical error");
			throw e;

		} finally {
			System.out.println("close db");
		}
		System.out.println("server done");
	}

}
