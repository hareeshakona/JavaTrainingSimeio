package com.hotelapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hotelapp.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("userId"));
		user.setFirstName(rs.getString("firstName"));
		user.setMiddleName(rs.getString("middleName"));
		user.setLastName(rs.getString("lastName"));
		user.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
		user.setCity(rs.getString("city"));
		user.setEmailId(rs.getString("email"));
		user.setSecurityQuestion(rs.getString("securityQuestion"));
		user.setSecurityAnswer(rs.getString("securityAnswer"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
