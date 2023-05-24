package com.oops.basics;

public class ConOverload {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		Vehicle vehicle1 = new Vehicle("Civic");
		Vehicle vehicle2 = new Vehicle("A100","Audi");
		Vehicle vehicle3 = new Vehicle("City","Honda", 500000);
		
		vehicle.getDetails();
		vehicle1.getDetails();
		vehicle2.getDetails();
		vehicle3.getDetails();

	}

}
