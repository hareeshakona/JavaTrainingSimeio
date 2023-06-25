package com.hotelapp.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotelapp.exceptions.UserNotFoundException;
import com.hotelapp.model.AccessLog;
import com.hotelapp.model.User;
import com.hotelapp.model.UserDTO;
import com.hotelapp.repository.IAccessLogRepository;
import com.hotelapp.repository.IUserRepository;
import com.hotelapp.util.MessageResponse;

@Service
public class UserServiceImpl implements IUserService {

	IUserRepository userRepository;

	public UserServiceImpl(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Autowired
	IAccessLogRepository accessLogRepository;

	@Bean
	BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDTO addUser(User user) {

		String userName = "";
		String password = "";
		String encodedPassword = "";
		boolean userNameInUse = false;
		// Generate UID and check if the UID is existing in db
		do {
			userName = generateUID(user);
			userNameInUse = userRepository.findByUserName(userName).isPresent();

		} while (userNameInUse);

		// Generate password and encrypt it
		password = generatePassword();
		encodedPassword = passwordEncoder().encode(password);
		user.setUserName(userName);
		user.setPassword(encodedPassword);

		// If user could be added in the db then log the activity
		if (userRepository.addUser(user) > 0) {
			AccessLog accessLog = new AccessLog();
			accessLog.setUserName(userName);
			accessLog.setActivity("Register");
			accessLog.setAttemptedAt(LocalDateTime.now());
			accessLog.setStatus("Success");
			accessLog.setNumberOfAttempts(1);
			accessLogRepository.logActivity(accessLog);
		}

		// Return the UID and password
		UserDTO userDto = new UserDTO();
		userDto.setUserName(userName);
		userDto.setPassword(password);
		return userDto;

	}

	private static String generateUID(User user) {
		String firstName = user.getFirstName();
		String middleName = user.getMiddleName();
		String lastName = user.getLastName();
		String city = user.getCity();
		String uid = "";
		if (!middleName.isBlank()) {
			uid = city.substring(0, 2) + firstName.substring(0, 1) + middleName.substring(0, 1)
					+ lastName.substring(0, 1) + getRandomNumber();
		} else {
			uid = city.substring(0, 2) + firstName.substring(0, 2) + lastName.substring(0, 1) + getRandomNumber();
		}
		return uid.toUpperCase();
	}

	private static String getRandomNumber() {
		Integer number = (new Random()).nextInt(10);
		return number.toString();
	}

	private static String generatePassword() {
		final int passwordSize = 10;
		final String validSpecialCharacters = "!@#$%&*()_[]{}|:.,><";
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();
		while (password.length() < passwordSize) {
			char character = (char) random.nextInt(Character.MAX_VALUE);
			if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')
					|| (character >= '0' && character <= '9')
					|| validSpecialCharacters.contains(String.valueOf(character))) {
				password.append(character);
			}
		}
		return password.toString();

	}

	@Override
	public void updateUser(String userName, String securityQuestion, String securityAnswer) {
		userRepository.updateUser(userName, securityQuestion, securityAnswer);

	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteUser(userId);

	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(int userId) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(userId);
		return user.orElseThrow(() -> new UserNotFoundException("Invalid Id"));
	}

	@Override
	public User getByUserName(String userName) throws UserNotFoundException {
		Optional<User> user = userRepository.findByUserName(userName);
		return user.orElseThrow(() -> new UserNotFoundException("Invalid user name"));
	}

	@Override
	public List<User> getByCity(String city) throws UserNotFoundException {
		List<User> users = userRepository.findByCity(city);
		if (users.isEmpty()) {
			throw new UserNotFoundException("No users found from city " + city);
		}
		return users;
	}

	@Override
	public MessageResponse loginUser(UserDTO userDto) {
		String userName = userDto.getUserName();
		String password = userDto.getPassword();

		Optional<User> user = userRepository.findByUserName(userName);
		if (user.isPresent()) {
			if (passwordEncoder().matches(password, user.get().getPassword())) {
				AccessLog accessLog = new AccessLog();
				accessLog.setUserName(userName);
				accessLog.setActivity("Login");
				accessLog.setAttemptedAt(LocalDateTime.now());
				accessLog.setStatus("Success");
				accessLog.setNumberOfAttempts(1);
				accessLogRepository.logActivity(accessLog);
				return new MessageResponse("Login Successful!!");
			} else {
				AccessLog accessLog = new AccessLog();
				accessLog.setUserName(userName);
				accessLog.setActivity("Login");
				accessLog.setAttemptedAt(LocalDateTime.now());
				accessLog.setStatus("Failed");
				accessLog.setNumberOfAttempts(1);
				accessLogRepository.logActivity(accessLog);
				return new MessageResponse("Error: Invalid Password!");
			}
		} else
			return new MessageResponse("Error : Invalid Username!");

	}

	@Override
	public MessageResponse changePassword(UserDTO userDto) {
		String userName = userDto.getUserName();
		String password = passwordEncoder().encode(userDto.getPassword());
		
		if (userRepository.changePassword(userName,password)>0) {
			return new MessageResponse("Password change successful.");
		}
		else return new MessageResponse("Password not changed.");
	}

}
