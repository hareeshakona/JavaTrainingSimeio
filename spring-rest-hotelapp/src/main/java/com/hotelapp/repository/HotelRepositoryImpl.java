package com.hotelapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.Hotel;
import com.hotelapp.util.Queries;

@Repository
public class HotelRepositoryImpl implements IHotelRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addHotel(Hotel hotel) {
		Object[] hotelArray = { hotel.getHotelName(), hotel.getCity(), hotel.getRating(), hotel.getPhone() };
		jdbcTemplate.update(Queries.HOTELINSERTQUERY, hotelArray);

	}

	@Override
	public void updateHotel(int hotelId, String phone) {
		jdbcTemplate.update(Queries.HOTELUPDATEQUERY, phone, hotelId);
	}

	@Override
	public void deleteHotel(int hotelId) {
		jdbcTemplate.update(Queries.HOTELDELETEQUERY, hotelId);

	}

	@Override
	public Optional<Hotel> findById(int hotelId) {
		try {
			Hotel hotel = jdbcTemplate.queryForObject(Queries.HOTELQUERYBYID, new HotelMapper(), hotelId);
			return Optional.ofNullable(hotel);
		} catch (DataAccessException e) {
			return Optional.ofNullable(null);
		}
	}

	@Override
	public List<Hotel> findByName(String hotelName) {
		return jdbcTemplate.query(Queries.HOTELQUERYBYNAME, new HotelMapper(), hotelName);
	}

	@Override
	public List<Hotel> findAll() {
		return jdbcTemplate.query(Queries.HOTELQUERYALL, new HotelMapper());
	}

	@Override
	public List<Hotel> findByNameContaining(String name) {
		return jdbcTemplate.query(Queries.HOTELQUERYBYNAMELIKE, new HotelMapper(), "%" + name + "%");
	}

	@Override
	public List<Hotel> findByCity(String city) {
		return jdbcTemplate.query(Queries.HOTELQUERYBYCITY, new HotelMapper(), city);
	}

	@Override
	public List<Hotel> findByCityAndMinimumRating(String city, int rating) {
		return jdbcTemplate.query(Queries.HOTELQUERYBYCITYRATING, new HotelMapper(), city, rating);
	}

	@Override
	public Optional<Hotel> findByCityAndName(String city, String hotelName) {
		try {
			Hotel hotel = jdbcTemplate.queryForObject(Queries.HOTELQUERYBYCITYANDNAME, new HotelMapper(), city,
					hotelName);
			return Optional.ofNullable(hotel);
		} catch (DataAccessException e) {
			return Optional.ofNullable(null);
		}
	}

	@Override
	public List<Hotel> findByCityAndRoomType(String city, String roomType) {
		return jdbcTemplate.query(Queries.HOTELQUERYBYCITYROOMTYPE, new HotelMapper(), city, roomType);
	}

	@Override
	public List<Hotel> findByCityAndMaximumRoomCost(String city, double roomCost) {
		return jdbcTemplate.query(Queries.HOTELQUERYBYCITYROOMCOST, new HotelMapper(), city, roomCost);
	}

}
