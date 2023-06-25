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

import com.hotelapp.model.User;
import com.hotelapp.model.UserDTO;
import com.hotelapp.service.IUserService;
import com.hotelapp.util.MessageResponse;

@RestController
@RequestMapping("/hotel-api-user")
public class UserController {

	IUserService userService;

	public UserController(IUserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/users/register")
	ResponseEntity<UserDTO> addUser(@RequestBody User user) {
		UserDTO userDto = userService.addUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "User registered");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(userDto);
	}

	@PostMapping("/users/login")
	ResponseEntity<MessageResponse> loginUser(@RequestBody UserDTO userDto) {
		MessageResponse message = userService.loginUser(userDto);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@PatchMapping("/users/changePassword")
	ResponseEntity<MessageResponse> changePassword(@RequestBody UserDTO userDto) {
		MessageResponse message = userService.changePassword(userDto);
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	@PatchMapping("/users/userName/{userName}")
	ResponseEntity<Void> updateUser(@PathVariable("userName") String userName, @RequestParam String securityQuestion,
			@RequestParam String securityAnswer) {
		userService.updateUser(userName, securityQuestion, securityAnswer);
		return ResponseEntity.accepted().build();
	}

	@DeleteMapping("/users/userId/{userId}")
	ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId) {
		userService.deleteUser(userId);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/users")
	ResponseEntity<List<User>> getAll() {
		List<User> users = userService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning all users");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(users);
	}

	@GetMapping("/users/userId/{userId}")
	ResponseEntity<User> getById(@PathVariable("userId") int userId) {
		User user = userService.getById(userId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning user by Id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(user);
	}

	@GetMapping("/users/userName/{userName}")
	ResponseEntity<User> getByUserName(@PathVariable("userName") String userName) {
		User user = userService.getByUserName(userName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning user by user name");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(user);
	}

	@GetMapping("/users/city/{city}")
	ResponseEntity<List<User>> getByCity(@PathVariable("city") String city) {
		List<User> users = userService.getByCity(city);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "Returning users by city");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(users);
	}
}
