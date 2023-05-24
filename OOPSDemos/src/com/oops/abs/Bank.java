package com.oops.abs;

public abstract class Bank {
	
	abstract void houseLoan();
	abstract void vehicleLoan();
	abstract void educationLoan();
	
	void admin() {
		System.out.println("admin details");
	}

}
