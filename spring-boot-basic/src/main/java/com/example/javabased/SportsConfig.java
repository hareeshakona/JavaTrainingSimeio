package com.example.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {
	
	@Bean
	public Player getPlayer() {
		return new Player();
	}
	
	@Bean
	public Cricket getCricket() {
		return new Cricket();
	}
	
	@Bean
	//@Primary
	public Football getFootball() {
		return new Football();
	}
	
}
