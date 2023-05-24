package com.hotelapp.service;

import java.util.List;
import java.util.Optional;

import com.hotelapp.model.Hotel;

public interface IHotelService {

	List<Hotel> getAll();

	Optional<Hotel> getByName(String name);

	List<Hotel> getByLocation(String location);

	List<Hotel> getByMinimumRating(int rating);

	List<Hotel> getByRoomType(String roomtype);

	List<Hotel> getByMaximumRoomCost(double roomcost);

}
