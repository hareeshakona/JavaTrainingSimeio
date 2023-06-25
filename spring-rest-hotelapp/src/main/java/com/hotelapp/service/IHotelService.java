package com.hotelapp.service;

import java.util.List;

import com.hotelapp.exceptions.HotelNotFoundException;
import com.hotelapp.model.Hotel;
import com.hotelapp.util.RoomType;

public interface IHotelService {

	void addHotel(Hotel hotel);

	void updateHotel(int hotelId, String phone);

	void deleteHotel(int hotelId);

	Hotel getById(int hotelId) throws HotelNotFoundException;

	List<Hotel> getByName(String hotelName) throws HotelNotFoundException;

	List<Hotel> getAll();

	List<Hotel> getByNameContaining(String name) throws HotelNotFoundException;

	List<Hotel> getByCity(String city) throws HotelNotFoundException;

	List<Hotel> getByCityAndMinimumRating(String city, int rating) throws HotelNotFoundException;

	Hotel getByCityAndName(String city, String hotelName) throws HotelNotFoundException;

	List<Hotel> getByCityAndRoomType(String city, RoomType roomType) throws HotelNotFoundException;

	List<Hotel> getByCityAndMaximumRoomCost(String city, double roomCost) throws HotelNotFoundException;
}
