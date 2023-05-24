package com.simeio.java8;

import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		
		Function<String, Integer> function = (str)->str.length();
		System.out.println(function.apply("Hareesha"));
		
		Function<Integer, String> function1 = (num)-> {
			if(num > 10) return "Welcome";
			else return "Bye";
		};
		System.out.println(function1.apply(100));
		

	}

}
