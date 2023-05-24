package com.simeio.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {
		
		List<Vehicle> vehicles = Arrays.asList(
				new Vehicle("i10","Hyundai",600000),
				new Vehicle("jupiter","TVS",80000),
				new Vehicle("sonet","Kia",1000000),
				new Vehicle("i20","Hyundai",900000),
				new Vehicle("astor","MG",1000000)
				);
		
		BrandSort brandsort = new BrandSort();
		Collections.sort(vehicles, brandsort);
		System.out.println("Sort by brand");
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}
		
		ModelSort modelsort = new ModelSort();
		Collections.sort(vehicles, modelsort);
		System.out.println("Sort by model");
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}
		
		Collections.sort(vehicles, new PriceSort());
		System.out.println("Sort by price");
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}
		
		Comparator<Vehicle> bs1 = (o1, o2)-> {
			return o1.getBrand().compareTo(o2.getBrand());
		};
		
		Collections.sort(vehicles, bs1);
		System.out.println("Sort by brand");	
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}
		
		Collections.sort(vehicles, (o1,o2)-> o1.getModel().compareTo(o2.getModel()));
		System.out.println("Sort by model");		
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}
		
		Collections.sort(vehicles, (o1,o2)->((Double)(o1.getPrice())).compareTo((Double)o2.getPrice()));
		System.out.println("Sort by price");
		for (Vehicle vehicle : vehicles) {
			System.out.println(vehicle);
		}

	}

}
