package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {

	void addBook(Book book);

	void updateBook(int bookId, double price);

	void deleteBook(int bookId);

	List<Book> getAll();

	Book getById(int bookId) throws BookNotFoundException;

	List<Book> getByCategory(String category) throws BookNotFoundException;

	List<Book> getByPriceLessThan(double price) throws BookNotFoundException;

	List<Book> getByTitleContaining(String title) throws BookNotFoundException;

	List<Book> getByAuthorStarting(String author) throws BookNotFoundException;
}
