package com.hotelapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hotelapp.model.Hotel;
import com.hotelapp.util.HotelDetails;

public class HotelServiceImpl implements IHotelService {

	@Override
	public List<Hotel> getAll() {
		return HotelDetails.showHotels();

	}

	@Override
	public Optional<Hotel> getByName(String name) {

		List<Hotel> allhotels = getAll();
		Optional<Hotel> hotelByName = allhotels.stream().filter(hotel -> hotel.getName().equals(name)).findAny();
		return hotelByName;

	}

	@Override
	public List<Hotel> getByLocation(String location) {

		List<Hotel> allhotels = getAll();
		return allhotels.stream().filter(hotel -> hotel.getLocation().equals(location)).collect(Collectors.toList());

	}

	@Override
	public List<Hotel> getByMinimumRating(int minimumrating) {

		List<Hotel> allhotels = getAll();
		return allhotels.stream().filter(hotel -> hotel.getRating() > minimumrating).collect(Collectors.toList());

	}

	@Override
	public List<Hotel> getByRoomType(String roomtype) {

		List<Hotel> allhotels = getAll();
		return allhotels.stream().filter(hotel -> hotel.getRoomtype().equals(roomtype)).collect(Collectors.toList());

	}

	@Override
	public List<Hotel> getByMaximumRoomCost(double maximumroomcost) {

		List<Hotel> allhotels = getAll();
		return allhotels.stream().filter(hotel -> hotel.getRoomcost() < maximumroomcost).collect(Collectors.toList());

	}

}
