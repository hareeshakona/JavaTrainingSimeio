package com.oops.basics;

public class OverloadDemo {

	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.area(10);
		shape.area(12.8);
		double tri = shape.area(10, 12.5f);
		System.out.println("Tri"+tri);
		
		int rect = shape.area(10, 20);
		System.out.println("Rect "+rect);

	}

}
