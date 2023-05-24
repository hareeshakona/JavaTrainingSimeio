package com.hotelapp.main;

import java.util.List;
import java.util.Optional;

import com.hotelapp.model.Hotel;
import com.hotelapp.service.HotelServiceImpl;
import com.hotelapp.service.IHotelService;

public class Client {

	public static void main(String[] args) {

		IHotelService ihotelService = new HotelServiceImpl();

		System.out.println("List of hotels :");
		List<Hotel> allhotels = ihotelService.getAll();
		for (Hotel hotel : allhotels)
			System.out.println(hotel);

		System.out.println();
		System.out.println("Hotels by location :");
		List<Hotel> hotelsByLocation = ihotelService.getByLocation("Bangalore");
		for (Hotel hotel : hotelsByLocation)
			System.out.println(hotel);

		System.out.println();
		System.out.println("Hotels by rating :");
		List<Hotel> hotelsByRating = ihotelService.getByMinimumRating(3);
		for (Hotel hotel : hotelsByRating)
			System.out.println(hotel);

		System.out.println();
		System.out.println("Hotels by room type :");
		List<Hotel> hotelsByRoomtype = ihotelService.getByRoomType("Double");
		for (Hotel hotel : hotelsByRoomtype)
			System.out.println(hotel);

		System.out.println();
		System.out.println("Hotels by room cost :");
		List<Hotel> hotelsByRoomcost = ihotelService.getByMaximumRoomCost(4000);
		for (Hotel hotel : hotelsByRoomcost)
			System.out.println(hotel);

		System.out.println();
		System.out.println("Hotel with name :");
		Optional<Hotel> hotelByName = ihotelService.getByName("Novotel");
		hotelByName.ifPresentOrElse(hotel -> System.out.println(hotel), () -> System.out.println("No hotel found"));

	}

}
