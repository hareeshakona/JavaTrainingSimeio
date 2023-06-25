package com.hotelapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hotelapp.model.User;
import com.hotelapp.util.Queries;

@Repository
public class UserRepositoryImpl implements IUserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addUser(User user) {
		Object[] userArray = { user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getDateOfBirth(),
				user.getCity(), user.getEmailId(), user.getSecurityQuestion(), user.getSecurityAnswer(),
				user.getUserName(), user.getPassword() };
		return jdbcTemplate.update(Queries.USERINSERTQUERY, userArray);
	}

	@Override
	public void updateUser(String userName, String securityQuestion, String securityAnswer) {
		jdbcTemplate.update(Queries.USERUPDATEQUERY, securityQuestion, securityAnswer, userName);

	}

	@Override
	public void deleteUser(int userId) {
		jdbcTemplate.update(Queries.USERDELETEQUERY, userId);

	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query(Queries.USERQUERYALL, new UserMapper());
	}

	@Override
	public Optional<User> findById(int userId) {
		try {
			User user = jdbcTemplate.queryForObject(Queries.USERQUERYBYID, new UserMapper(), userId);
			return Optional.ofNullable(user);
		} catch (DataAccessException e) {
			return Optional.ofNullable(null);
		}
	}

	@Override
	public Optional<User> findByUserName(String userName) {
		try {
			User user = jdbcTemplate.queryForObject(Queries.USERQUERYBYUSERNAME, new UserMapper(), userName);
			return Optional.ofNullable(user);
		} catch (DataAccessException e) {
			return Optional.ofNullable(null);
		}
	}

	@Override
	public List<User> findByCity(String city) {
		return jdbcTemplate.query(Queries.USERQUERYBYCITY, new UserMapper(), city);
	}

	@Override
	public int changePassword(String userName, String password) {
		return jdbcTemplate.update(Queries.USERCHANGEPASSWORDQUERY, password, userName);
		
	}

}
