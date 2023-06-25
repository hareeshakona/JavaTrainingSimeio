package com.hotelapp.service;

import java.util.List;

import com.hotelapp.exceptions.UserNotFoundException;
import com.hotelapp.model.User;
import com.hotelapp.model.UserDTO;
import com.hotelapp.util.MessageResponse;

public interface IUserService {

	UserDTO addUser(User user);

	void updateUser(String userName, String secretQuestion, String secretAnswer);

	void deleteUser(int userId);

	List<User> getAll();

	User getById(int userId) throws UserNotFoundException;

	User getByUserName(String userName) throws UserNotFoundException;

	List<User> getByCity(String city) throws UserNotFoundException;

	MessageResponse loginUser(UserDTO userDto);

	MessageResponse changePassword(UserDTO userDto);
}
