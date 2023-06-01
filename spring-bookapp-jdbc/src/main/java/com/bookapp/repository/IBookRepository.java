package com.bookapp.repository;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookRepository {

	void addBook(Book book);

	void updateBook(int bookId, double price);

	void deleteBook(int bookId);

	List<Book> findAll();

	Book findById(int bookId);

	List<Book> findByCategory(String category);

	List<Book> findByPriceLessThan(double price);

	List<Book> findByTitleContaining(String title);

	List<Book> findByAuthorStarting(String author);
}
