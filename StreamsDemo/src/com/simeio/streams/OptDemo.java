package com.simeio.streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class OptDemo {

	public static void main(String[] args) {

		Optional<String> optString = Arrays.asList("Java", "Html", "Spring", "Angular", "Node").stream().findFirst();

		// check if optional has value
		if (optString.isPresent())
			System.out.println(optString.get());

		// check if optional is empty
		Optional<String> optString1 = Arrays.asList("Java", "Html", "Spring", "Angular", "Node").stream().skip(5)
				.findFirst();
		

		if (optString1.isEmpty())
			System.out.println("No value present");

		// Using IfPresentOrElse
		Arrays.asList("Java", "Html", "Spring", "Angular", "Node").stream().skip(5).findFirst()
				.ifPresentOrElse(str -> System.out.println("hi"), () -> System.out.println("Value not available"));

		// Using OrElse
		String result = Arrays.asList("Java", "Html", "Spring", "Angular", "Node").stream().skip(5).findFirst()
				.orElse("No course available");
		System.out.println(result);
		
		Integer num1 = Stream.of(3,5,7,9,11,18).filter(num->num%2==0).findAny().orElseGet(()->100);
		System.out.println(num1);

	}

}
