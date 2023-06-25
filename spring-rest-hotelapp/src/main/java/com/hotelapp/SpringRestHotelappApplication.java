package com.hotelapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.hotelapp.model.User;
import com.hotelapp.service.IUserService;
import com.hotelapp.util.CsvHelper;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringRestHotelappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestHotelappApplication.class, args);
	}

	@Autowired
	private CsvHelper csvHelper;

	@Autowired
	private IUserService userService;

	@Override
	public void run(String... args) throws Exception {
//		List<User> users = csvHelper.getUserList("users.csv");
//		users.stream().forEach(user -> userService.addUser(user));
	}

}
