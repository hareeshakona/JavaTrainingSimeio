package com.simeio.autowiring;

import org.springframework.stereotype.Component;

@Component
public interface Instrument {

	void play(String song);
}
