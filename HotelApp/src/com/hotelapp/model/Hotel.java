package com.hotelapp.model;

public class Hotel {

	private String name;
	private String location;
	private int rating;
	private String roomtype;
	private int availablerooms;
	private double roomcost;
	
	public Hotel() {
		super();
		
	}

	public Hotel(String name, String location, int rating, String roomtype, int availablerooms, double roomcost) {
		super();
		this.name = name;
		this.location = location;
		this.rating = rating;
		this.roomtype = roomtype;
		this.availablerooms = availablerooms;
		this.roomcost = roomcost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public int getAvailablerooms() {
		return availablerooms;
	}

	public void setAvailablerooms(int availablerooms) {
		this.availablerooms = availablerooms;
	}

	public double getRoomcost() {
		return roomcost;
	}

	public void setRoomcost(double roomcost) {
		this.roomcost = roomcost;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", location=" + location + ", rating=" + rating + ", roomtype=" + roomtype
				+ ", availablerooms=" + availablerooms + ", roomcost=" + roomcost + "]";
	}

	
}
