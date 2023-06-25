package com.hotelapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotelapp.exceptions.HotelNotFoundException;
import com.hotelapp.model.Hotel;
import com.hotelapp.repository.IHotelRepository;
import com.hotelapp.util.RoomType;

@Service
public class HotelServiceImpl implements IHotelService {

	IHotelRepository hotelRepository;

	public HotelServiceImpl(IHotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

	@Override
	public void addHotel(Hotel hotel) {
		hotelRepository.addHotel(hotel);

	}

	@Override
	public void updateHotel(int hotelId, String phone) {
		hotelRepository.updateHotel(hotelId, phone);

	}

	@Override
	public void deleteHotel(int hotelId) {
		hotelRepository.deleteHotel(hotelId);

	}

	@Override
	public Hotel getById(int hotelId) throws HotelNotFoundException {
		Optional<Hotel> hotel = hotelRepository.findById(hotelId);
		return hotel.orElseThrow(() -> new HotelNotFoundException("Invalid Id"));
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public List<Hotel> getByName(String hotelName) throws HotelNotFoundException {
		List<Hotel> hotels = hotelRepository.findByName(hotelName);
		if (hotels.isEmpty()) {
			throw new HotelNotFoundException("No hotels found with name " + hotelName);
		}
		return hotels;
	}

	@Override
	public List<Hotel> getByNameContaining(String name) throws HotelNotFoundException {
		List<Hotel> hotels = hotelRepository.findByNameContaining(name);
		if (hotels.isEmpty()) {
			throw new HotelNotFoundException("No hotels found containing name " + name);
		}
		return hotels;
	}

	@Override
	public List<Hotel> getByCity(String city) throws HotelNotFoundException {
		List<Hotel> hotels = hotelRepository.findByCity(city);
		if (hotels.isEmpty()) {
			throw new HotelNotFoundException("No hotels found with city " + city);
		}
		return hotels;
	}

	@Override
	public List<Hotel> getByCityAndMinimumRating(String city, int rating) throws HotelNotFoundException {
		List<Hotel> hotels = hotelRepository.findByCityAndMinimumRating(city, rating);
		if (hotels.isEmpty()) {
			throw new HotelNotFoundException("No hotels found in city " + city + " with minimum rating " + rating);
		}
		return hotels;
	}

	@Override
	public Hotel getByCityAndName(String city, String hotelName) throws HotelNotFoundException {
		Optional<Hotel> hotel = hotelRepository.findByCityAndName(city, hotelName);
		return hotel
				.orElseThrow(() -> new HotelNotFoundException("No hotel with name " + hotelName + " found in " + city));
	}

	@Override
	public List<Hotel> getByCityAndRoomType(String city, RoomType roomType) throws HotelNotFoundException {
		List<Hotel> hotels = hotelRepository.findByCityAndRoomType(city, roomType.toString());
		if (hotels.isEmpty()) {
			throw new HotelNotFoundException("No hotels found in city " + city + " having room type " + roomType);
		}
		return hotels;
	}

	@Override
	public List<Hotel> getByCityAndMaximumRoomCost(String city, double roomCost) throws HotelNotFoundException {
		List<Hotel> hotels = hotelRepository.findByCityAndMaximumRoomCost(city, roomCost);
		if (hotels.isEmpty()) {
			throw new HotelNotFoundException("No hotels found in city " + city + " with maximum room cost " + roomCost);
		}
		return hotels;
	}

}
