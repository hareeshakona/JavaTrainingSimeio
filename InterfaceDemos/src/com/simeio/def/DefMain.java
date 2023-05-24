package com.simeio.def;

public class DefMain {

	public static void main(String[] args) {
		IMobile mobile = new User();
		mobile.call();
		mobile.messageUser();
		
		ILaptop laptop = (ILaptop)mobile;
		laptop.call();
		laptop.messageUser();
	}
}
