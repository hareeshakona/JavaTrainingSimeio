package com.hotelapp.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapp.exceptions.ReservationNotFoundException;
import com.hotelapp.model.Hotel;
import com.hotelapp.model.Reservation;
import com.hotelapp.model.Room;
import com.hotelapp.repository.IReservationRepository;
import com.hotelapp.util.MessageResponse;
import com.hotelapp.util.PaymentStatus;
import com.hotelapp.util.RoomType;

@Service
public class ReservationServiceImpl implements IReservationService {

	IReservationRepository reservationRepository;

	public ReservationServiceImpl(IReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	@Autowired
	IHotelService hotelService;

	@Autowired
	IRoomService roomService;

	@Autowired
	IUserService userService;

	@Override
	public MessageResponse reserve(RoomType roomType, String hotelName, String city, String userName,
			String checkInDate, String checkOutDate) {

		// Get the hotel by city and hotel name assuming there are no duplicate hotel
		// names in a city
		Hotel hotel = hotelService.getByCityAndName(city, hotelName);
		// Get list of rooms in a hotel of particular room type
		List<Room> rooms = roomService.getByHotelId(hotel.getHotelId()).stream()
				.filter(room -> room.getRoomType().equals(roomType)).collect(Collectors.toList());

		LocalDate startDate = LocalDate.parse(checkInDate);
		LocalDate endDate = LocalDate.parse(checkOutDate);
		int days = (int) ChronoUnit.DAYS.between(startDate, endDate);

		boolean roomAvailable = false;

		for (Room room : rooms) {
			List<Reservation> reservations = getByRoom(room.getRoomId());
			if (reservations.isEmpty()) {
				roomAvailable = true;
			} else {
				for (Reservation resv : reservations) {
					// Since validations for end date to be after start date isn't in place
					// comparing both start and end date with reservation checkin date
					if ((resv.getCheckInDate().compareTo(startDate) > 0)
							&& (resv.getCheckInDate().compareTo(endDate) > 0)
							|| (resv.getCheckOutDate().compareTo(startDate) < 0)
									&& (resv.getCheckOutDate().compareTo(endDate) < 0)) {
						roomAvailable = true;
					}
				}
			}

			if (roomAvailable) {
				Reservation reservation = new Reservation();
				reservation.setRoomId(room.getRoomId());
				reservation.setUserId(userService.getByUserName(userName).getUserId());
				reservation.setCheckInDate(startDate);
				reservation.setCheckOutDate(endDate);
				reservation.setAmount(room.getCostPerNight() * days);
				reservation.setPaymentStatus(PaymentStatus.PENDING);
				addReservation(reservation);
				break;
			}
		}

		if (roomAvailable) {
			return new MessageResponse("Reservation successful!");
		} else
			return new MessageResponse("No room available. Reservation not successful!");

	}

	@Override
	public void addReservation(Reservation reservation) {
		reservationRepository.addReservation(reservation);

	}

	@Override
	public void updateReservation(int reservationId, PaymentStatus paymentStatus) {
		reservationRepository.updateReservation(reservationId, paymentStatus);

	}

	@Override
	public void deleteReservation(int reservationId) {
		reservationRepository.deleteReservation(reservationId);

	}

	@Override
	public Reservation getById(int reservationId) throws ReservationNotFoundException {
		Optional<Reservation> reservation = reservationRepository.findById(reservationId);
		return reservation.orElseThrow(() -> new ReservationNotFoundException("Invalid Id"));
	}

	@Override
	public List<Reservation> getAll() {
		return reservationRepository.findAll();
	}

	@Override
	public List<Reservation> getByRoom(int roomId) {
		return reservationRepository.findByRoomId(roomId);
	}

	@Override
	public List<Reservation> getByRoomId(int roomId) throws ReservationNotFoundException {
		List<Reservation> reservations = reservationRepository.findByRoomId(roomId);
		if (reservations.isEmpty()) {
			throw new ReservationNotFoundException("No reservations found for room Id " + roomId);
		}
		return reservations;
	}

	@Override
	public List<Reservation> getByUserId(int userId) throws ReservationNotFoundException {
		List<Reservation> reservations = reservationRepository.findByUserId(userId);
		if (reservations.isEmpty()) {
			throw new ReservationNotFoundException("No reservations found for user Id " + userId);
		}
		return reservations;
	}

	@Override
	public List<Reservation> getByPaymentStatus(PaymentStatus paymentStatus) throws ReservationNotFoundException {
		List<Reservation> reservations = reservationRepository.findByPaymentStatus(paymentStatus);
		if (reservations.isEmpty()) {
			throw new ReservationNotFoundException("No reservations found with payment status as " + paymentStatus);
		}
		return reservations;
	}

	@Override
	public List<Reservation> getByUserIdAndPaymentStatus(int userId, PaymentStatus paymentStatus)
			throws ReservationNotFoundException {
		List<Reservation> reservations = reservationRepository.findByUserIdAndPaymentStatus(userId, paymentStatus);
		if (reservations.isEmpty()) {
			throw new ReservationNotFoundException(
					"No reservations found for user id " + userId + " with payment status as " + paymentStatus);
		}
		return reservations;
	}
}
