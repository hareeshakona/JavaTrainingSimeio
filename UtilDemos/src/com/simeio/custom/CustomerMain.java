package com.simeio.custom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerMain {

	public static void main(String[] args) {

		ArrayList<Customer> customers = new ArrayList<>();

		customers.add(new Customer("Ratan", "Mumbai", 5));
		customers.add(new Customer("Sundar", "Bangalore", 1));
		customers.add(new Customer("Sudha", "Chennai", 2));
		customers.add(new Customer("Abdul", "Trivandrum", 3));
		customers.add(new Customer("Narayan", "Bangalore", 4));
		

		System.out.println("Using iterator");
		Iterator<Customer> iterator = customers.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());

		System.out.println("Using for each");
		for (Customer customer : customers)
			System.out.println(customer);

		System.out.println("Enter city :");
		Scanner sc = new Scanner(System.in);
		String city = sc.nextLine();

		ArrayList<Customer> customerByCity = new ArrayList<>();

		for (Customer customer : customers) {
			if (customer.getCity().equals(city))
				customerByCity.add(customer);
		}

		System.out.println("Customers in city " + city);
		Iterator<Customer> customeriterator = customerByCity.iterator();
		while (customeriterator.hasNext())
			System.out.println(customeriterator.next());
		
		System.out.println("Customers in sorted order");
		Collections.sort(customers);
		for(Customer customer : customers) {
			System.out.println(customer);
		}

		sc.close();

	}

}
