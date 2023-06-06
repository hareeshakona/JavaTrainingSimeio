package com.simeio.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Performer {
	
	@Autowired
	@Qualifier("violin")
	Instrument vinstrument;
	
	@Autowired
	Instrument instrument;
	
	@Autowired
	Instrument guitar;
	
	void playSong(String type, String song) {
		System.out.println("Playing song..");
		if(type.equals("guitar")) guitar.play(song);
		if(type.equals("violin")) vinstrument.play(song);
		if(type.equals("keyboard")) instrument.play(song);
	}

}
