package com.bookapp.repository;

import java.util.List;
import java.util.Optional;

import com.bookapp.model.Book;

public interface IBookRepository {
	void addBook(Book book);

	void updateBook(int bookId, double price);

	void deleteBook(int bookId);

	List<Book> findAll();

	Optional<Book> findById(int bookId);

	List<Book> findByCategory(String category);

	List<Book> findByPriceLessThan(double price);

	List<Book> findByTitleContaining(String title, String category);

	List<Book> findByAuthorStarting(String author);
}
