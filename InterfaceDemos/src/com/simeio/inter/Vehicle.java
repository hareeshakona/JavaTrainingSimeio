package com.simeio.inter;

public abstract class Vehicle implements Insurance{
	
	private String model;
	private String brand;
	private double price;
	
	public Vehicle(String model, String brand, double price) {
		super();
		this.model = model;
		this.brand = brand;
		this.price = price;
	}

	void printDetails() {
		System.out.println("model: "+model+"\n"+"brand: "+brand+"\n"+"price: "+price+"\n");
	}
	
	abstract void showMileage();


}
