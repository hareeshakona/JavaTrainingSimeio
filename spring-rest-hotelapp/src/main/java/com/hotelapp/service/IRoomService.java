package com.hotelapp.service;

import java.util.List;

import com.hotelapp.exceptions.RoomNotFoundException;
import com.hotelapp.model.Room;
import com.hotelapp.util.RoomType;

public interface IRoomService {

	void addRoom(Room room);

	void updateRoom(int roomId, double costPerNight);

	void deleteRoom(int roomId);

	Room getById(int roomId) throws RoomNotFoundException;

	List<Room> getAll();

	List<Room> getByHotelId(int hotelId) throws RoomNotFoundException;

	List<Room> getByRoomNumber(int roomNumber) throws RoomNotFoundException;

	List<Room> getByRoomType(RoomType roomType) throws RoomNotFoundException;

	List<Room> getByCapacity(int capacity) throws RoomNotFoundException;

	List<Room> getByMaxCostPerNight(double costPerNight) throws RoomNotFoundException;

	List<Room> getByRoomTypeAndCapacity(RoomType roomType, int capacity) throws RoomNotFoundException;

	List<Room> getByRoomTypeAndMaxCostPerNight(RoomType roomType, double costPerNight) throws RoomNotFoundException;
}
