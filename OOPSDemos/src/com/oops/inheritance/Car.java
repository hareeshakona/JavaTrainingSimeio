package com.oops.inheritance;

public class Car extends FourWheeler{
	
	String category;
	
	
	public Car() {
		brand="Honda";
		type="Luxury";
		category="Sedan";
	}


	void show() {
		System.out.println(category);
	}

}
