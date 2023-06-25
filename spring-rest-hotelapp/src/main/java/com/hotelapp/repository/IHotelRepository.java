package com.hotelapp.repository;

import java.util.List;
import java.util.Optional;

import com.hotelapp.model.Hotel;

public interface IHotelRepository {

	void addHotel(Hotel hotel);

	void updateHotel(int hotelId, String phone);

	void deleteHotel(int hotelId);

	Optional<Hotel> findById(int hotelId);

	List<Hotel> findByName(String hotelName);

	List<Hotel> findAll();

	List<Hotel> findByNameContaining(String name);

	List<Hotel> findByCity(String city);

	List<Hotel> findByCityAndMinimumRating(String city, int rating);

	Optional<Hotel> findByCityAndName(String city, String hotelName);

	List<Hotel> findByCityAndRoomType(String city, String roomType);

	List<Hotel> findByCityAndMaximumRoomCost(String city, double roomCost);

}
