package com.hotelapp.util;

import java.util.Arrays;
import java.util.List;

import com.hotelapp.model.Hotel;

public class HotelDetails {
	
	public static List<Hotel> showHotels() {
		List<Hotel> hotels = Arrays.asList(new Hotel("Western Keys Hotel", "Bangalore", 3, "Private Suite", 2, 6500),
				new Hotel("Olive Hotel", "Bangalore", 2, "Double", 1, 2000),
				new Hotel("Castle Suites", "Bangalore", 4, "Double", 2, 4000),
				new Hotel("Country Inn", "Mumbai", 3, "Private Suite", 1, 9000),
				new Hotel("Novotel", "Mumbai", 5, "Double", 4, 7000),
				new Hotel("Hyatt", "Mumbai", 5, "Single", 3, 5000),
				new Hotel("Citadines", "Chennai", 2, "Single", 1, 1800),
				new Hotel("ITC Grand Chola", "Chennai", 5, "Double", 2, 12000),
				new Hotel("Comfort Park", "Chennai", 3, "Single", 3, 2000),
				new Hotel("Marriott", "Hyderabad", 5, "Double", 5, 6500));

		return hotels;
	}
}
