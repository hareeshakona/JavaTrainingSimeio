package com.hotelapp.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapp.model.Hotel;
import com.hotelapp.service.IHotelService;
import com.hotelapp.util.RoomType;

@RestController
@RequestMapping("/hotel-api")
public class HotelController {

	IHotelService hotelService;

	public HotelController(IHotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}

	@PostMapping("/hotels")
	ResponseEntity<Void> addHotel(@RequestBody Hotel hotel) {
		hotelService.addHotel(hotel);
		return ResponseEntity.accepted().build();
	}

	@PatchMapping("/hotels/hotelId/{hotelId}")
	ResponseEntity<Void> updateHotel(@PathVariable("hotelId") int hotelId, @RequestParam("phone") String phone) {
		hotelService.updateHotel(hotelId, phone);
		return ResponseEntity.accepted().build();
	}

	@DeleteMapping("/hotels/hotelId/{hotelId}")
	ResponseEntity<Void> deleteHotel(@PathVariable("hotelId") int hotelId) {
		hotelService.deleteHotel(hotelId);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/hotels")
	ResponseEntity<List<Hotel>> getAll() {
		List<Hotel> hotels = hotelService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning all hotels");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(hotels);
	}

	@GetMapping("/hotels/hotelId/{hotelId}")
	ResponseEntity<Hotel> getById(@PathVariable("hotelId") int hotelId) {
		Hotel hotel = hotelService.getById(hotelId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning hotel by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(hotel);
	}

	@GetMapping("/hotels/hotelName/{hotelName}")
	ResponseEntity<List<Hotel>> getByName(@PathVariable("hotelName") String hotelName) {
		List<Hotel> hotels = hotelService.getByName(hotelName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning hotel by name " + hotelName);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(hotels);
	}

	@GetMapping("/hotels/hotelNameLike/{hotelName}")
	ResponseEntity<List<Hotel>> getByNameContaining(@PathVariable("hotelName") String hotelName) {
		List<Hotel> hotels = hotelService.getByNameContaining(hotelName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning hotels containing hotel name " + hotelName);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(hotels);
	}

	@GetMapping("/hotels/city/{city}")
	ResponseEntity<List<Hotel>> getByCity(@PathVariable("city") String city) {
		List<Hotel> hotels = hotelService.getByCity(city);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning hotels in city " + city);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(hotels);
	}

	@GetMapping("/hotels/city/{city}/rating/{rating}")
	ResponseEntity<List<Hotel>> getByCityAndMinimumRating(@PathVariable("city") String city,
			@PathVariable("rating") int rating) {
		List<Hotel> hotels = hotelService.getByCityAndMinimumRating(city, rating);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning hotels in city " + city + " with minimum rating " + rating);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(hotels);
	}

	@GetMapping("/hotels/city/{city}/roomType/{roomType}")
	ResponseEntity<List<Hotel>> getByCityAndRoomType(@PathVariable("city") String city,
			@PathVariable("roomType") String roomType) {
		List<Hotel> hotels = hotelService.getByCityAndRoomType(city, RoomType.valueOf(roomType));
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning hotels in city " + city + " having room type " + roomType);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(hotels);
	}

	@GetMapping("/hotels/city/{city}/roomCost/{roomCost}")
	ResponseEntity<List<Hotel>> getByCityAndMaximumRoomCost(@PathVariable("city") String city,
			@PathVariable("roomCost") double roomCost) {
		List<Hotel> hotels = hotelService.getByCityAndMaximumRoomCost(city, roomCost);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning hotels in city " + city + " with max cost per night " + roomCost);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(hotels);
	}
}
