package com.oops.basics;

public class Vehicle {

	private String model;
	private String brand;
	private double price;

	public Vehicle() {
		System.out.println("In default");
		
	}

	public Vehicle(String model) {
		this.model = model;
		System.out.println("one para constructor");
	}

	public Vehicle(String model, String brand) {				
		this(model);
		this.brand = brand;
		System.out.println("two para constructor");
	}

	public Vehicle(String model, String brand, double price) {
		this(model,brand);
		this.price = price;
		System.out.println("three para constructor");		

	}
	
	void getDetails() {
		if(model!=null)
			System.out.println(model);
		if(brand!=null)
			System.out.println(brand);
		if(price>0.0)
			System.out.println(price);
	}

}
