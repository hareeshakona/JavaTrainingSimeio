package com.hotelapp.model;

import com.hotelapp.util.RoomType;

public class Room {

	private Integer roomId;
	private String roomNumber;
	private RoomType roomType;
	private int capacity;
	private double costPerNight;
	private Integer hotelId;

	public Room() {
		super();
	}

	public Room(Integer roomId, String roomNumber, RoomType roomType, int capacity, double costPerNight,
			Integer hotelId) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.capacity = capacity;
		this.costPerNight = costPerNight;
		this.hotelId = hotelId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getCostPerNight() {
		return costPerNight;
	}

	public void setCostPerNight(double costPerNight) {
		this.costPerNight = costPerNight;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", roomType=" + roomType + ", capacity="
				+ capacity + ", costPerNight=" + costPerNight + ", hotelId=" + hotelId + "]";
	}

}
