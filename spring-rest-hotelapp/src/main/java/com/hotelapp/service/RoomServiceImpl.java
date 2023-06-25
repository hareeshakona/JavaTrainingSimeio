package com.hotelapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hotelapp.exceptions.RoomNotFoundException;
import com.hotelapp.model.Room;
import com.hotelapp.repository.IRoomRepository;
import com.hotelapp.util.RoomType;

@Service
public class RoomServiceImpl implements IRoomService {

	IRoomRepository roomRepository;

	public RoomServiceImpl(IRoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@Override
	public void addRoom(Room room) {
		roomRepository.addRoom(room);

	}

	@Override
	public void updateRoom(int roomId, double costPerNight) {
		roomRepository.updateRoom(roomId, costPerNight);

	}

	@Override
	public void deleteRoom(int roomId) {
		roomRepository.deleteRoom(roomId);

	}

	@Override
	public Room getById(int roomId) throws RoomNotFoundException {
		Optional<Room> room = roomRepository.findById(roomId);
		return room.orElseThrow(() -> new RoomNotFoundException("Invalid Id"));
	}

	@Override
	public List<Room> getAll() {
		return roomRepository.findAll();
	}

	public List<Room> getByHotelId(int hotelId) throws RoomNotFoundException {
		List<Room> rooms = roomRepository.findByHotelId(hotelId);
		if (rooms.isEmpty()) {
			throw new RoomNotFoundException("No rooms found for hotel Id " + hotelId);
		}
		return rooms;
	}

	@Override
	public List<Room> getByRoomNumber(int roomNumber) throws RoomNotFoundException {
		List<Room> rooms = roomRepository.findByRoomNumber(roomNumber);
		if (rooms.isEmpty()) {
			throw new RoomNotFoundException("No rooms found having number " + roomNumber);
		}
		return rooms;
	}

	@Override
	public List<Room> getByRoomType(RoomType roomType) throws RoomNotFoundException {
		List<Room> rooms = roomRepository.findByRoomType(roomType);
		if (rooms.isEmpty()) {
			throw new RoomNotFoundException("No rooms found of type " + roomType);
		}
		return rooms;
	}

	@Override
	public List<Room> getByCapacity(int capacity) throws RoomNotFoundException {
		List<Room> rooms = roomRepository.findByCapacity(capacity);
		if (rooms.isEmpty()) {
			throw new RoomNotFoundException("No rooms found having capacity " + capacity);
		}
		return rooms;
	}

	@Override
	public List<Room> getByMaxCostPerNight(double costPerNight) throws RoomNotFoundException {
		List<Room> rooms = roomRepository.findByMaxCostPerNight(costPerNight);
		if (rooms.isEmpty()) {
			throw new RoomNotFoundException("No rooms found for max cost " + costPerNight);
		}
		return rooms;
	}

	@Override
	public List<Room> getByRoomTypeAndCapacity(RoomType roomType, int capacity) throws RoomNotFoundException {
		List<Room> rooms = roomRepository.findByRoomTypeAndCapacity(roomType, capacity);
		if (rooms.isEmpty()) {
			throw new RoomNotFoundException("No rooms found for room type " + roomType + " with capacity " + capacity);
		}
		return rooms;
	}

	@Override
	public List<Room> getByRoomTypeAndMaxCostPerNight(RoomType roomType, double costPerNight)
			throws RoomNotFoundException {
		List<Room> rooms = roomRepository.findByRoomTypeAndMaxCostPerNight(roomType, costPerNight);
		if (rooms.isEmpty()) {
			throw new RoomNotFoundException(
					"No rooms found for room type " + roomType + " with max cost " + costPerNight);
		}
		return rooms;
	}

}
