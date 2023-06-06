package com.bookapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

@Service
public class BookServiceImpl implements IBookService {

	BookDetails details;

	public BookServiceImpl(BookDetails details) {
		super();
		this.details = details;
	}

	@Override
	public List<Book> getAll() {
		return details.showBooks();
	}


	@Override
	public List<Book> getByAuthorStarting(String author) {
		return details.showBooks()
				.stream()
				.filter(book -> book.getAuthor().startsWith(author))
				.sorted((book1, book2) -> (book1.getTitle()).compareTo(book2.getTitle()))
				.collect(Collectors.toList());
	}

}
