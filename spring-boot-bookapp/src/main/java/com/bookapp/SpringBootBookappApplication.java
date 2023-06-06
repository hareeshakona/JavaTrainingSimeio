package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBootBookappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookappApplication.class, args);
	}
	
	@Autowired
	IBookService bookService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("List of books :");
		bookService.getAll().forEach(System.out::println);
		System.out.println("Book by Id :");
		System.out.println(bookService.getById(2));
		System.out.println("Books by category :");
		bookService.getByCategory("Tech").forEach(System.out::println);
		System.out.println("Books by price less than :");
		bookService.getByPriceLessThan(1000).forEach(System.out::println);
		System.out.println("Books by title containing :");
		bookService.getByTitleContaining("Java").forEach(System.out::println);
		System.out.println("Books by author starting :");
		bookService.getByAuthorStarting("Usb").forEach(System.out::println);
		
	}

}
