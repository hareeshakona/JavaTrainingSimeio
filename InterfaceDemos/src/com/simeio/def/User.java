package com.simeio.def;

public class User implements IMobile,ILaptop {

	@Override
	public void call() {
		System.out.println("Call using number");
		System.out.println("Call using whatsapp");

	}

	@Override
	public void playGames() {
		System.out.println("Games from playstore");

	}

	@Override
	public void messageUser() {		
		ILaptop.super.messageUser();
	}

}
