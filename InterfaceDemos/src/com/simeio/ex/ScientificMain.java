package com.simeio.ex;

public class ScientificMain {
	
	public static void main(String[] args) {
		
		IScientific scientific = new ScientificCal();
		scientific.add(20, 30);
		scientific.diff(30,10);
		scientific.product(45, 9);
		scientific.cube(33);
		scientific.squareRoot(49);
	}

}
