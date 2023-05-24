package com.simeio.custom;

public class Customer implements Comparable<Customer>{
	
	private String name;
	private String city;
	private int customerId;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String city, int customerId) {
		super();
		this.name = name;
		this.city = city;
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", city=" + city + ", customerId=" + customerId + "]";
	}

	@Override
	public int compareTo(Customer o) {
		
		//return this.getCity().compareTo(o.getCity());
		return ((Integer)this.getCustomerId()).compareTo((Integer)o.getCustomerId());
	}
	

}
