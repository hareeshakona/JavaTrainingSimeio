package com.example.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NewShapeFactory {

	//if more than one bean of same type is available
	@Autowired
	@Qualifier("triangle") //autowiring by type
	Shape tshape;
	
	//if bean name is same as instance variable name
	@Autowired
	Shape shape; //autowiring by name
	
	@Autowired
	Shape rectangle;
	
	public void printArea(String s, int x, int y) {
		System.out.println("printing area");
		if(s.equals("square"))
			shape.area(x, y);
		if(s.equals("rectangle"))
			rectangle.area(x, y);
		if(s.equals("triangle"))
			tshape.area(x, y);
	}
	
}
