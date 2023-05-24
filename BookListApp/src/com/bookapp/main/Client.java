package com.bookapp.main;

import java.util.List;
import java.util.Optional;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class Client {

	public static void main(String[] args) {
		
		IBookService ibookService = new BookServiceImpl();
		
		System.out.println("List of books :");
		List<Book> allbooks = ibookService.getAll();
		for(Book book : allbooks) System.out.println(book.getTitle());
		
		System.out.println();
		System.out.println("Books by author Kathy :");
		List<Book> bookbyauthor = ibookService.getByAuthor("Kathy");
		for(Book book : bookbyauthor) System.out.println(book.getTitle());
		
		System.out.println();
		System.out.println("Books by category Fiction :");
		List<Book> bookbycategory = ibookService.getByCategory("Fiction");
		for(Book book : bookbycategory) System.out.println(book.getTitle());
		
		System.out.println();
		System.out.println("Book with Id 2 :");
		Optional<Book> bookbyid = ibookService.getById(2);
		bookbyid.ifPresentOrElse(book -> System.out.println(book.getTitle()), ()->System.out.println("No book found with the given id"));


	}

}
