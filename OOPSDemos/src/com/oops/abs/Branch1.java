package com.oops.abs;

public class Branch1 extends Bank {

	@Override
	void houseLoan() {
		System.out.println("Housing loan interest in Branch1 is 8.5%");

	}

	@Override
	void vehicleLoan() {
		System.out.println("Vehicle loan interest in Branch1 is 6%");

	}

	@Override
	void educationLoan() {
		System.out.println("Education loan interest in Branch1 is 5%");

	}
	
	void staffDetails() {
		System.out.println("Total staff in Branch1 is 50");
	}

}
