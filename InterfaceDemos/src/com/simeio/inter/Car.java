package com.simeio.inter;

public class Car extends Vehicle implements Accessories {

	public Car(String model, String brand, double price) {
		super(model, brand, price);
		
	}

	@Override
	void showMileage() {
		System.out.println("20km/l");

	}

	@Override
	public void showTypes() {
		System.out.println("Insurance for damage");
		
	}

	@Override
	public void externalAcc() {
		System.out.println("External covers");
		System.out.println("Rear view cameras");
		
	}

	@Override
	public void internalAcc() {
		System.out.println("Music system");
		System.out.println("Dash camera");
		
	}

}
