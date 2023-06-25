package com.hotelapp.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapp.model.Room;
import com.hotelapp.service.IRoomService;
import com.hotelapp.util.RoomType;

@RestController
@RequestMapping("/hotel-api-room")
public class RoomController {

	IRoomService roomService;

	public RoomController(IRoomService roomService) {
		super();
		this.roomService = roomService;
	}

	@PostMapping("/rooms")
	ResponseEntity<Void> addRoom(@RequestBody Room room) {
		roomService.addRoom(room);
		return ResponseEntity.accepted().build();
	}

	@PatchMapping("/rooms/roomId/{roomId}")
	ResponseEntity<Void> updateRoom(@PathVariable("roomId") int roomId,
			@RequestParam("costPerNight") double costPerNight) {
		roomService.updateRoom(roomId, costPerNight);
		return ResponseEntity.accepted().build();
	}

	@DeleteMapping("/rooms/roomId/{roomId}")
	ResponseEntity<Void> deleteRoom(@PathVariable("roomId") int roomId) {
		roomService.deleteRoom(roomId);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/rooms")
	ResponseEntity<List<Room>> getAll() {
		List<Room> rooms = roomService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning all rooms");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(rooms);
	}

	@GetMapping("/rooms/roomId/{roomId}")
	ResponseEntity<Room> getById(@PathVariable("roomId") int roomId) {
		Room room = roomService.getById(roomId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning room by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(room);
	}

	@GetMapping("/rooms/roomNumber/{roomNumber}")
	ResponseEntity<List<Room>> getByRoomNumber(@PathVariable("roomNumber") int roomNumber) {
		List<Room> rooms = roomService.getByRoomNumber(roomNumber);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning rooms by roomNumber");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(rooms);
	}

	@GetMapping("/rooms/roomType/{roomType}")
	ResponseEntity<List<Room>> getByRoomType(@PathVariable("roomType") RoomType roomType) {
		List<Room> rooms = roomService.getByRoomType(roomType);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning rooms by roomType");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(rooms);
	}

	@GetMapping("/rooms/capacity/{capacity}")
	ResponseEntity<List<Room>> getByCapacity(@PathVariable("capacity") int capacity) {
		List<Room> rooms = roomService.getByCapacity(capacity);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning rooms by capacity");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(rooms);
	}

	@GetMapping("/rooms/roomCost/{roomCost}")
	ResponseEntity<List<Room>> getByMaxCostPerNight(@PathVariable("roomCost") double costPerNight) {
		List<Room> rooms = roomService.getByMaxCostPerNight(costPerNight);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning rooms having max cost per night as " + costPerNight);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(rooms);
	}

	@GetMapping("/rooms/roomType/{roomType}/capacity/{capacity}")
	ResponseEntity<List<Room>> getByRoomTypeAndCapacity(@PathVariable("roomType") RoomType roomType,
			@PathVariable("capacity") int capacity) {
		List<Room> rooms = roomService.getByRoomTypeAndCapacity(roomType, capacity);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning rooms of type " + roomType + " and capacity " + capacity);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(rooms);
	}

	@GetMapping("/rooms/roomType/{roomType}/roomCost/{roomCost}")
	ResponseEntity<List<Room>> getByRoomTypeAndMaxCostPerNight(@PathVariable("roomType") RoomType roomType,
			@PathVariable("roomCost") double costPerNight) {
		List<Room> rooms = roomService.getByRoomTypeAndMaxCostPerNight(roomType, costPerNight);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning rooms of type " + roomType + " having max cost per night " + costPerNight);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(rooms);
	}

}
