package com.example.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeFactory {
	
	@Autowired
	@Qualifier("triangle")
	Shape shape;
	
	/*void printArea(String str, int x, int y) {

		switch(str) {
		case "Square" : {
			shape = new Square();
			shape.area(x, y);
			break;
		}
		case "Rectangle" : {
			shape = new Rectangle();
			shape.area(x, y);
			break;
		}
		case "Triangle" : {
			shape = new Triangle();
			shape.area(x, y);
			break;
		}
		default: {
			System.out.println("Invalid shape");
		}
		}
	}*/
	
	public void printArea(String s, int x, int y) {
		shape.area(x, y);
	}
	
	
	

}
