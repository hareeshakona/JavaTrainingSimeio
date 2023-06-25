package com.hotelapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Room;
import com.hotelapp.util.Queries;
import com.hotelapp.util.RoomType;

@Repository
public class RoomRepositoryImpl implements IRoomRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addRoom(Room room) {
		Object[] roomArray = { room.getRoomNumber(), room.getRoomType().toString(), room.getCapacity(),
				room.getCostPerNight(), room.getHotelId() };
		jdbcTemplate.update(Queries.ROOMINSERTQUERY, roomArray);

	}

	@Override
	public void updateRoom(int roomId, double costPerNight) {
		jdbcTemplate.update(Queries.ROOMUPDATEQUERY, costPerNight, roomId);

	}

	@Override
	public void deleteRoom(int roomId) {
		jdbcTemplate.update(Queries.ROOMDELETEQUERY, roomId);

	}

	@Override
	public Optional<Room> findById(int roomId) {
		try {
			Room room = jdbcTemplate.queryForObject(Queries.ROOMQUERYBYID, new RoomMapper(), roomId);
			return Optional.ofNullable(room);
		} catch (DataAccessException e) {
			return Optional.ofNullable(null);
		}

	}

	@Override
	public List<Room> findAll() {
		return jdbcTemplate.query(Queries.ROOMQUERYALL, new RoomMapper());
	}

	@Override
	public List<Room> findByHotelId(int hotelId) {
		return jdbcTemplate.query(Queries.ROOMQUERYBYHOTELID, new RoomMapper(), hotelId);
	}

	@Override
	public List<Room> findByRoomNumber(int roomNumber) {
		return jdbcTemplate.query(Queries.ROOMQUERYBYROOMNUMBER, new RoomMapper(), roomNumber);
	}

	@Override
	public List<Room> findByRoomType(RoomType roomType) {
		return jdbcTemplate.query(Queries.ROOMQUERYBYROOMTYPE, new RoomMapper(), roomType);
	}

	@Override
	public List<Room> findByCapacity(int capacity) {
		return jdbcTemplate.query(Queries.ROOMQUERYBYCAPACITY, new RoomMapper(), capacity);
	}

	@Override
	public List<Room> findByMaxCostPerNight(double costPerNight) {
		return jdbcTemplate.query(Queries.ROOMQUERYBYMAXCOST, new RoomMapper(), costPerNight);
	}

	@Override
	public List<Room> findByRoomTypeAndCapacity(RoomType roomType, int capacity) {
		return jdbcTemplate.query(Queries.ROOMQUERYBYTYPEANDCAPACITY, new RoomMapper(), roomType, capacity);
	}

	@Override
	public List<Room> findByRoomTypeAndMaxCostPerNight(RoomType roomType, double costPerNight) {
		return jdbcTemplate.query(Queries.ROOMQUERYBYTYPEANDMAXCOST, new RoomMapper(), roomType, costPerNight);
	}

}
