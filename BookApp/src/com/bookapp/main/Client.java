package com.bookapp.main;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class Client {

	public static void main(String[] args) {
		
		IBookService ibookService = new BookServiceImpl();
		
		System.out.println("List of books :");
		Book[] allbooks = ibookService.getAll();
		for(Book book : allbooks) System.out.println(book.getTitle());
		
		System.out.println("Books by author Kathy :");
		Book[] bookbyauthor = ibookService.getByAuthor("Kathy");
		for(Book book : bookbyauthor) System.out.println(book.getTitle());
		
		System.out.println("Books by category Fiction :");
		Book[] bookbycategory = ibookService.getByCategory("Fiction");
		for(Book book : bookbycategory) System.out.println(book.getTitle());
		
		System.out.println("Book with Id 2 :");
		Book bookbyid = ibookService.getById(2);
		System.out.println(bookbyid.getTitle());

	}

}
