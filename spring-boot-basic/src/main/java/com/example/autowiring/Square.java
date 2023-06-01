package com.example.autowiring;

import org.springframework.stereotype.Component;

@Component("shape")
public class Square implements Shape{

	@Override
	public void area(int x, int y) {
		System.out.println("Square area "+(x*y));
		
	}

}
