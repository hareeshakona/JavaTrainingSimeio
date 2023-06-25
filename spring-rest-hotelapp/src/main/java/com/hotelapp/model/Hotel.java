package com.hotelapp.model;

public class Hotel {

	private Integer hotelId;
	private String hotelName;
	private String city;
	private int rating;
	private String phone;

	public Hotel() {
		super();
	}

	public Hotel(Integer hotelId, String hotelName, String city, int rating, String phone) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
		this.rating = rating;
		this.phone = phone;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", city=" + city + ", rating=" + rating
				+ ", phone=" + phone + "]";
	}

}
