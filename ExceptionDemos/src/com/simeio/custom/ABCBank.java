package com.simeio.custom;

public class ABCBank {

	int balance = 2000;

	void withdraw(double amount) throws OutOfLimitsException, NegativeBalanceException {
		System.out.println("In Bank");
		try {
			if (amount > 5000) {
				throw new OutOfLimitsException("Amount exceeding the withdrawal limit...");
			}
			if (balance - amount <= 0) {
				throw new NegativeBalanceException("Balance is zero");
			}

			balance -= amount;
			System.out.println("Remaining " + balance);

		} catch (Exception e) {
			System.out.println("exception..." + e);
			throw e;

		} finally {
			System.out.println("close db");
		}
		System.out.println("completed");
	}

}
