package com.simeio.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Violin implements Instrument {

	public void play(String song) {
		System.out.println("Playing "+song+" on violin");

	}

}
