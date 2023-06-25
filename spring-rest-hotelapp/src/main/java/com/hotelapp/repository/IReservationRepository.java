package com.hotelapp.repository;

import java.util.List;
import java.util.Optional;

import com.hotelapp.model.Reservation;
import com.hotelapp.util.PaymentStatus;

public interface IReservationRepository {

	void addReservation(Reservation reservation);

	void updateReservation(int reservationId, PaymentStatus paymentStatus);

	void deleteReservation(int reservationId);

	Optional<Reservation> findById(int reservationId);

	List<Reservation> findAll();

	List<Reservation> findByRoomId(int roomId);

	List<Reservation> findByUserId(int userId);

	List<Reservation> findByPaymentStatus(PaymentStatus paymentStatus);

	List<Reservation> findByUserIdAndPaymentStatus(int userId, PaymentStatus paymentStatus);
}
