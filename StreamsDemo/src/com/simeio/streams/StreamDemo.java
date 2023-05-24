package com.simeio.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		
		Stream.generate(()->"hello").limit(10).forEach((str)->System.out.println(str));
		
		Stream.generate(()->(int)(Math.random()*10)).limit(10).forEach((num)->System.out.println(num));
		
		Function<String, String> function = (str)-> {
			return str.toUpperCase();
		};
		
		System.out.println();
		List<String> courses = Arrays.asList("java", "html", "javascript", "angular", "css", "spring");
		
		courses.stream().map(str->str.length()).forEach((str)->System.out.println(str));
	

	}

}
