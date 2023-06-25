package com.hotelapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hotelapp.model.Reservation;
import com.hotelapp.util.PaymentStatus;

public class ReservationMapper implements RowMapper<Reservation> {

	@Override
	public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reservation reservation = new Reservation();
		reservation.setReservationId(rs.getInt("reservationId"));
		reservation.setRoomId(rs.getInt("roomId"));
		reservation.setUserId(rs.getInt("userId"));
		reservation.setCheckInDate(rs.getDate("checkInDate").toLocalDate());
		reservation.setCheckOutDate(rs.getDate("checkOutDate").toLocalDate());
		reservation.setAmount(rs.getDouble("amount"));
		reservation.setPaymentStatus(PaymentStatus.valueOf(rs.getString("paymentStatus")));
		return reservation;
	}

}
