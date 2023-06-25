package com.hotelapp.model;

import java.time.LocalDate;

import com.hotelapp.util.PaymentStatus;

public class Reservation {

	private Integer reservationId;
	private Integer roomId;
	private Integer userId;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private double amount;
	private PaymentStatus paymentStatus;

	public Reservation() {
		super();
	}

	public Reservation(Integer reservationId, Integer roomId, Integer userId, LocalDate checkInDate,
			LocalDate checkOutDate, double amount, PaymentStatus paymentStatus) {
		super();
		this.reservationId = reservationId;
		this.roomId = roomId;
		this.userId = userId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", roomId=" + roomId + ", userId=" + userId
				+ ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", amount=" + amount
				+ ", paymentStatus=" + paymentStatus + "]";
	}
}
