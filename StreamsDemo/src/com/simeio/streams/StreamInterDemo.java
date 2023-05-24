package com.simeio.streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInterDemo {
	public static void main(String[] args) {

		List<String> courses = Arrays.asList("java", "html", "javascript", "angular", "css", "spring");

		List<String> newcourses = courses.stream().filter((str) -> str.contains("a")).collect(Collectors.toList());

		System.out.println(newcourses);
		
		System.out.println("String length > 3");

		Iterator<String> iterator = courses.stream().filter(str -> str.length() > 3).sorted().limit(2).iterator();

		while (iterator.hasNext()) {
			String course = iterator.next();
			System.out.println(course);
		}
		
		System.out.println("Print without iterator");
		
		courses.stream().filter(str -> str.length()>3).sorted().forEach(str -> System.out.println(str.toUpperCase()));
		
		System.out.println("Using skip");
		
		courses.stream().filter(str->str.length()>3).sorted().skip(2).distinct().forEach(str->System.out.println(str.toUpperCase()));
		

	}
}
