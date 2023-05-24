package com.simeio.def;

public class Employee implements IBonusCalculator, ILoanCalculator {

	@Override
	public void calcInterest(double amount) {
		
		System.out.println("Calculated interest"+(amount*0.5));

	}

	@Override
	public void greet() {
		
		IBonusCalculator.super.greet();
		ILoanCalculator.super.greet();
	}

}
