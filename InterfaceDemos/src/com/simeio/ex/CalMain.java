package com.simeio.ex;

public class CalMain {

	public static void main(String[] args) {
		
		ICalculator calculator = new BasicCalculator();
		calculator.add(10, 20);
		calculator.diff(20, 10);
		calculator.product(40, 5);

	}

}
