package com.hotelapp.repository;

import java.util.List;
import java.util.Optional;

import com.hotelapp.model.Room;
import com.hotelapp.util.RoomType;

public interface IRoomRepository {

	void addRoom(Room room);

	void updateRoom(int roomId, double costPerNight);

	void deleteRoom(int roomId);

	Optional<Room> findById(int roomId);

	List<Room> findAll();

	List<Room> findByHotelId(int hotelId);

	List<Room> findByRoomNumber(int roomNumber);

	List<Room> findByRoomType(RoomType roomType);

	List<Room> findByCapacity(int capacity);

	List<Room> findByMaxCostPerNight(double costPerNight);

	List<Room> findByRoomTypeAndCapacity(RoomType roomType, int capacity);

	List<Room> findByRoomTypeAndMaxCostPerNight(RoomType roomType, double costPerNight);

}
