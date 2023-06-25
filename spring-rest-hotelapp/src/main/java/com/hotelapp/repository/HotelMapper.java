package com.hotelapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hotelapp.model.Hotel;

public class HotelMapper implements RowMapper<Hotel> {

	@Override
	public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hotel hotel = new Hotel();
		hotel.setHotelId(rs.getInt("hotelId"));
		hotel.setHotelName(rs.getString("hotelName"));
		hotel.setCity(rs.getString("city"));
		hotel.setRating(rs.getInt("rating"));
		hotel.setPhone(rs.getString("phone"));
		return hotel;
	}

}
