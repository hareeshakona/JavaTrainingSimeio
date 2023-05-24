package com.oops.basics;

public class Shape {
	
	
	 void area(int x) { 
		 System.out.println("Sq "+ (x * x)); 
	 }
	 
	
	void area (double x) {
		System.out.println("Circle "+ (Math.PI * x * x));
	}
	
	double area (int x, float y) {
		return (0.5 * x * y);
	}
	
	int area (int x, int y) {
		return x * y;
	}

}
