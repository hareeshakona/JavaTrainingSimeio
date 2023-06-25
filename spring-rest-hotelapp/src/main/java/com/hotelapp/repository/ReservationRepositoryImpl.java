package com.hotelapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Reservation;
import com.hotelapp.util.PaymentStatus;
import com.hotelapp.util.Queries;

@Repository
public class ReservationRepositoryImpl implements IReservationRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addReservation(Reservation reservation) {
		Object[] reservationArray = { reservation.getRoomId(), reservation.getUserId(), reservation.getCheckInDate(),
				reservation.getCheckOutDate(), reservation.getAmount(), reservation.getPaymentStatus().toString() };
		jdbcTemplate.update(Queries.RESVINSERTQUERY, reservationArray);
	}

	@Override
	public void updateReservation(int reservationId, PaymentStatus paymentStatus) {
		jdbcTemplate.update(Queries.RESVUPDATEQUERY, paymentStatus.toString(), reservationId);
	}

	@Override
	public void deleteReservation(int reservationId) {
		jdbcTemplate.update(Queries.RESVDELETEQUERY, reservationId);
	}

	@Override
	public Optional<Reservation> findById(int reservationId) {
		try {
			Reservation reservation = jdbcTemplate.queryForObject(Queries.RESVQUERYBYID, new ReservationMapper(),
					reservationId);
			return Optional.ofNullable(reservation);
		} catch (DataAccessException e) {
			return Optional.ofNullable(null);
		}
	}

	@Override
	public List<Reservation> findAll() {
		return jdbcTemplate.query(Queries.RESVQUERYALL, new ReservationMapper());
	}

	@Override
	public List<Reservation> findByRoomId(int roomId) {
		return jdbcTemplate.query(Queries.RESVQUERYBYROOMID, new ReservationMapper(), roomId);
	}

	@Override
	public List<Reservation> findByUserId(int userId) {
		return jdbcTemplate.query(Queries.RESVQUERYBYUSERID, new ReservationMapper(), userId);
	}

	@Override
	public List<Reservation> findByPaymentStatus(PaymentStatus paymentStatus) {
		return jdbcTemplate.query(Queries.RESVQUERYBYPAYMENTSTATUS, new ReservationMapper(), paymentStatus.toString());
	}

	@Override
	public List<Reservation> findByUserIdAndPaymentStatus(int userId, PaymentStatus paymentStatus) {
		return jdbcTemplate.query(Queries.RESVQUERYBYUSERIDANDPAYMENT, new ReservationMapper(), userId,
				paymentStatus.toString());
	}

}
