package com.bookapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> getAll() {
		return BookDetails.showBooks();
	}

	@Override
	public List<Book> getByAuthor(String author) {
		List<Book> allbooks = getAll();
		return allbooks.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());

	}

	@Override
	public Optional<Book> getById(int bookId) {

		List<Book> allbooks = getAll();
		Optional<Book> bookbyId = allbooks.stream().filter(book -> book.getBookId().intValue() == bookId).findAny();
		return bookbyId;
	}

	@Override
	public List<Book> getByCategory(String category) {
		List<Book> allbooks = getAll();
		return allbooks.stream().filter(book -> book.getCategory().equals(category)).collect(Collectors.toList());
	}

}
