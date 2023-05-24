package com.simeio.ex;

public class BasicCalculator implements ICalculator {

	@Override
	public void add(int x, int y) {
		System.out.println("Add value is "+(x+y));
		
	}

	@Override
	public void product(int x, int y) {
		System.out.println("Product value is "+(x*y));
		
	}

	@Override
	public void diff(int x, int y) {
		System.out.println("Difference value is "+(x-y));
		
	}

}
