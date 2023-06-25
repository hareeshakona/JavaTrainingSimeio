package com.hotelapp.service;

import java.util.List;

import com.hotelapp.exceptions.ReservationNotFoundException;
import com.hotelapp.model.Reservation;
import com.hotelapp.util.MessageResponse;
import com.hotelapp.util.PaymentStatus;
import com.hotelapp.util.RoomType;

public interface IReservationService {

	MessageResponse reserve(RoomType roomType, String hotelName, String city, String userName, String checkInDate,
			String checkOutDate);

	void addReservation(Reservation reservation);

	void updateReservation(int reservationId, PaymentStatus paymentStatus);

	void deleteReservation(int reservationId);

	Reservation getById(int reservationId) throws ReservationNotFoundException;

	List<Reservation> getAll();

	List<Reservation> getByRoomId(int roomId) throws ReservationNotFoundException;

	List<Reservation> getByUserId(int userId) throws ReservationNotFoundException;

	List<Reservation> getByPaymentStatus(PaymentStatus paymentStatus) throws ReservationNotFoundException;

	List<Reservation> getByUserIdAndPaymentStatus(int userId, PaymentStatus paymentStatus)
			throws ReservationNotFoundException;

	List<Reservation> getByRoom(int roomId);
}
