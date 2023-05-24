package com.simeio.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.simeio.custom.Customer;

class Demo implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println("Hello "+t);
		
	}
	
}
public class FunDemo {

	public static void main(String[] args) {
		
		Consumer<String> consumer = new Demo();
		consumer.accept("Hareesha");
		
		Consumer<String> consumer1 = (str)->System.out.println(str.toUpperCase());
		consumer1.accept("welcome");
		
		Consumer<Integer> consumer2 = (number)->System.out.println(number*number);
		consumer2.accept(5);
		
		BiConsumer<String,String> consumer3 = (str1,str2)-> System.out.println(str1+str2);
		consumer3.accept("Welcome", "Hareesha");
		
		BiConsumer<String, Integer> consumer4 = (str1,number)->{
			if (number>5)System.out.println("Welcome"+str1);
			else System.out.println("Wrong user");
		};
		consumer4.accept("Hareesha", 5);
		
		Consumer<Customer> consumer5 = (customer)-> System.out.println(customer);
		consumer5.accept(new Customer("Ram", "Chennai",1));
		
		Supplier<String> supplier = ()->"Hello".toUpperCase();
		supplier.get();
		
		Supplier<List<String>> supplier1 = ()->{
			return Arrays.asList("Apple","Mango");
		};
		System.out.println(supplier1.get());
		
		Predicate<String> predicate = (str)-> {
			if(str.equals("Ram")) return true;
			else return false;
		};
		System.out.println(predicate.test("Ram"));
		
		
	}

}
