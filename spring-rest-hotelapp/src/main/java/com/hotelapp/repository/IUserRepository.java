package com.hotelapp.repository;

import java.util.List;
import java.util.Optional;

import com.hotelapp.model.User;

public interface IUserRepository {

	int addUser(User user);

	void updateUser(String userName, String secretQuestion, String secretAnswer);

	void deleteUser(int userId);

	List<User> findAll();

	Optional<User> findById(int userId);

	Optional<User> findByUserName(String userName);

	List<User> findByCity(String city);

	int changePassword(String userName, String password);

}
