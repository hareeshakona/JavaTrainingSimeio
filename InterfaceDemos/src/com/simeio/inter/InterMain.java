package com.simeio.inter;

public class InterMain {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Car("City","Honda",900000);
		vehicle.printDetails();
		vehicle.showMileage();
		
		Insurance insurance = vehicle;
		insurance.showTypes();
		
		Accessories accessories = (Accessories) vehicle;
		accessories.internalAcc();
		accessories.externalAcc();
		
		Vehicle vehicle2 = new Bike("Jupiter","TVS",85000);
		vehicle2.showMileage();
		vehicle2.showTypes();
		
		Insurance insurance2 = vehicle2;
		insurance2.showTypes();
		
		Accessories accessories2 = (Accessories) vehicle2;
		accessories2.internalAcc();
		accessories2.externalAcc();
		
		
	}
}
