package com.simeio.inter;

public class Bike extends Vehicle {

	public Bike(String model, String brand, double price) {
		super(model, brand, price);
		
	}

	@Override
	public void showTypes() {
		System.out.println("Insurance for damage for bike");

	}

	@Override
	void showMileage() {
		System.out.println("50km/l");

	}

}
