package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.BookDTO;

public interface IBookService {
	void addBook(BookDTO bookDto);

	void updateBook(int bookId, double price);

	void deleteBook(int bookId);

	List<BookDTO> getAll();

	BookDTO getById(int bookId) throws BookNotFoundException;

	List<BookDTO> getByCategory(String category) throws BookNotFoundException;

	List<BookDTO> getByPriceLessThan(double price) throws BookNotFoundException;

	List<BookDTO> getByTitleContaining(String title, String category) throws BookNotFoundException;

	List<BookDTO> getByAuthorStarting(String author) throws BookNotFoundException;

}
