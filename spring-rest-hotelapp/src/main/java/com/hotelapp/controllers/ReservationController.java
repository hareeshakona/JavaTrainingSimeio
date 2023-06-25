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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapp.model.Reservation;
import com.hotelapp.service.IReservationService;
import com.hotelapp.util.MessageResponse;
import com.hotelapp.util.PaymentStatus;
import com.hotelapp.util.RoomType;

@RestController
@RequestMapping("/hotel-api-reservation")
public class ReservationController {

	IReservationService reservationService;

	public ReservationController(IReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@PostMapping("/reserve")
	ResponseEntity<MessageResponse> reserve(@RequestParam("roomType") RoomType roomType,
			@RequestParam("hotelName") String hotelName, @RequestParam("city") String city,
			@RequestParam("userName") String userName, @RequestParam("checkInDate") String checkInDate,
			@RequestParam("checkOutDate") String checkOutDate) {
		MessageResponse message = reservationService.reserve(roomType, hotelName, city, userName, checkInDate,
				checkOutDate);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

//	@PostMapping("/reservations")
//	ResponseEntity<Void> addReservation(@RequestBody Reservation reservation) {
//		reservationService.addReservation(reservation);
//		return ResponseEntity.accepted().build();		
//	}

	@PatchMapping("/reservations/reservationId/{reservationId}")
	ResponseEntity<Void> updateReservation(@PathVariable("reservationId") int reservationId,
			@RequestParam("paymentStatus") PaymentStatus paymentStatus) {
		reservationService.updateReservation(reservationId, paymentStatus);
		return ResponseEntity.accepted().build();
	}

	@DeleteMapping("/reservations/reservationId/{reservationId}")
	ResponseEntity<Void> deleteReservation(@PathVariable("reservationId") int reservationId) {
		reservationService.deleteReservation(reservationId);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/reservations")
	ResponseEntity<List<Reservation>> getAll() {
		List<Reservation> reservations = reservationService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning all reservations");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reservations);
	}

	@GetMapping("/reservations/reservationId/{reservationId}")
	ResponseEntity<Reservation> getById(@PathVariable("reservationId") int reservationId) {
		Reservation reservation = reservationService.getById(reservationId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning reservation by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reservation);
	}

	@GetMapping("/reservations/roomId/{roomId}")
	ResponseEntity<List<Reservation>> getByRoomId(@PathVariable("roomId") int roomId) {
		List<Reservation> reservations = reservationService.getByRoomId(roomId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning reservations by room Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reservations);
	}

	@GetMapping("/reservations/userId/{userId}")
	ResponseEntity<List<Reservation>> getByUserId(@PathVariable("userId") int userId) {
		List<Reservation> reservations = reservationService.getByUserId(userId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning reservations by user Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reservations);
	}

	@GetMapping("/reservations/paymentStatus/{paymentStatus}")
	ResponseEntity<List<Reservation>> getByPaymentStatus(@PathVariable("paymentStatus") PaymentStatus paymentStatus) {
		List<Reservation> reservations = reservationService.getByPaymentStatus(paymentStatus);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning reservations by payment status");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reservations);
	}

	@GetMapping("/reservations/userId/{userId}/paymentStatus/{paymentStatus}")
	ResponseEntity<List<Reservation>> getByUserIdAndPaymentStatus(@PathVariable("userId") int userId,
			@PathVariable("paymentStatus") PaymentStatus paymentStatus) {
		List<Reservation> reservations = reservationService.getByUserIdAndPaymentStatus(userId, paymentStatus);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning reservations by user Id and payment status");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reservations);
	}
}
