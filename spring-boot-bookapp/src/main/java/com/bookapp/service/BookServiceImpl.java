package com.bookapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
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
	public Book getById(int bookId) {
		return details.showBooks()
				.stream()
				.filter(book -> book.getBookId() == bookId)
				.findFirst().orElseThrow(() -> new BookNotFoundException("Invalid book id"));
	}

	@Override
	public List<Book> getByCategory(String category) {
		return details.showBooks()
				.stream()
				.filter(book -> book.getCategory().equals(category))
				.sorted((book1, book2) -> (book1.getTitle()).compareTo(book2.getTitle()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> getByPriceLessThan(double price) {
		return details.showBooks()
				.stream()
				.filter(book -> book.getPrice() < price)
				.sorted((book1, book2) -> ((Double)book1.getPrice()).compareTo((Double)book2.getPrice()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> getByTitleContaining(String title) {
		return details.showBooks()
				.stream()
				.filter(book -> book.getTitle().contains(title))
				//.sorted(Comparator.comparing(book -> book.getTitle().compareTo(title)))
				//.sorted((book1, book2) -> (book1.getTitle()).compareTo(book2.getTitle()))
				.sorted(Comparator.comparing(Book::getTitle).reversed())
				.collect(Collectors.toList());
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
