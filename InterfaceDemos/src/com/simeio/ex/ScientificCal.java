package com.simeio.ex;

public class ScientificCal extends BasicCalculator implements IScientific {

	@Override
	public void squareRoot(int x) {
		System.out.println("Squareroot is "+Math.sqrt(x));

	}

	@Override
	public void cube(int x) {
		System.out.println("Cube is "+(x*x*x));

	}

}
