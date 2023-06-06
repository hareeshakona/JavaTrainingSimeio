package com.simeio.autowiring;

import org.springframework.stereotype.Component;

@Component("instrument")
public class Keyboard implements Instrument{

	public void play(String song) {
		System.out.println("Playing "+song+" on keyboard");
		
	}

}
