package com.simeio.def;

public interface IMobile {

	void call();
	void playGames();
	default void messageUser() {
		System.out.println("Message via whatsapp");
	}
}

interface ILaptop {
	
	void call();	
	default void messageUser() {
		System.out.println("message via teams, gmail");
	}
}

