package com.oops.abs;

public abstract class Branch2 extends Bank{

	@Override
	void houseLoan() {
		System.out.println("Housing loan interest in Branch2 is 9%");
		
	}

	@Override
	void educationLoan() {
		System.out.println("Education loan interest in Branch2 is 7%");
		
	}
	
	void loanDetails() {
		System.out.println("Branch2 loan details");
	}

}
