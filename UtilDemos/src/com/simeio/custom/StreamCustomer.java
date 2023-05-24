package com.simeio.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCustomer {

	public static void main(String[] args) {
		
		ArrayList<Customer> customers = new ArrayList<>();

		customers.add(new Customer("Ratan", "Mumbai", 5));
		customers.add(new Customer("Sundar", "Bangalore", 1));
		customers.add(new Customer("Sudha", "Chennai", 2));
		customers.add(new Customer("Abdul", "Trivandrum", 3));
		customers.add(new Customer("Narayan", "Bangalore", 4));
		
		//get customers who belong to a city
		List<Customer> customersByCity = customers.stream().filter((customer)-> customer.getCity().equals("Bangalore")).collect(Collectors.toList());
		System.out.println(customersByCity);

	}

}
