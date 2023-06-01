package com.example.javabased;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Player {

	@Autowired
	@Qualifier("getFootball")
	ISports sports;
	
	public List<String> showOngoingMatches() {
		return sports.playMatches();
	}
}
