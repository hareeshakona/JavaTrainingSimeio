package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJdbcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJdbcApplication.class, args);
	}
	
	@Autowired
	private IBookService bookService;

	@Override
	public void run(String... args) throws Exception {
		/*Book book = new Book();
		book.setTitle("History facts");
		book.setAuthor("Kim Barley");
		book.setCategory("Non fiction");
		book.setPrice(1500);
		
		bookService.addBook(book);
		bookService.updateBook(2,800);
		bookService.deleteBook(3);*/
		
		System.out.println("List of all books");
		bookService.getAll().forEach(System.out::println);
		
		System.out.println("Book by Id");
		System.out.println(bookService.getById(4));
		
		System.out.println("Books by category :");
		bookService.getByCategory("Non fiction").forEach(System.out::println);
		
		System.out.println("Books by price less than :");
		bookService.getByPriceLessThan(900).forEach(System.out::println);
		
		System.out.println("Books by title containing :");
		bookService.getByTitleContaining("Java").forEach(System.out::println);
		
		System.out.println("Books by author starting :");
		bookService.getByAuthorStarting("Usb").forEach(System.out::println);
		
		
	}

}
