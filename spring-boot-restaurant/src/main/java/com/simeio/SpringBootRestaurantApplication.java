package com.simeio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simeio.auto.Restaurant;

@SpringBootApplication
public class SpringBootRestaurantApplication implements CommandLineRunner{
	
	Restaurant restaurant;

	@Autowired
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestaurantApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restaurant.displayMenu("Indian").forEach(System.out::println);
	}

}
