package com.hotelapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hotelapp.model.Room;
import com.hotelapp.util.RoomType;

public class RoomMapper implements RowMapper<Room> {

	@Override
	public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
		Room room = new Room();
		room.setRoomId(rs.getInt("roomId"));
		room.setRoomNumber(rs.getString("roomNumber"));
		room.setRoomType(RoomType.valueOf(rs.getString("roomType")));
		room.setCapacity(rs.getInt("capacity"));
		room.setCostPerNight(rs.getDouble("costPerNight"));
		room.setHotelId(rs.getInt("hotelId"));
		return room;
	}

}
