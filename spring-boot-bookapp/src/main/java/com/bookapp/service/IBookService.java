package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookService {
	
	List<Book> getAll();
	Book getById(int bookId);
	List<Book> getByCategory(String category);
	List<Book> getByPriceLessThan(double price);
	List<Book> getByTitleContaining(String title);
	List<Book> getByAuthorStarting(String author);
}
