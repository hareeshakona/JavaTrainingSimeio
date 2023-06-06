package com.simeio.autowiring;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {

	@Override
	public void area(int x, int y) {
		System.out.println("Triangle area "+(0.5*x*y));
		
	}

}
