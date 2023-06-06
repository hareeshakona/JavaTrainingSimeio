package com.bookapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {
	

	IBookRepository bookRepository;
	
	public BookServiceImpl(IBookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public void addBook(Book book) {
		bookRepository.addBook(book);
		
	}

	@Override
	public void updateBook(int bookId, double price) {
		bookRepository.updateBook(bookId, price);
		
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteBook(bookId);
		
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException{
		Book book = bookRepository.findById(bookId);
		if(book==null)
			throw new BookNotFoundException("Invalid Id");
		return book;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = bookRepository.findByCategory(category);
		if (books.isEmpty())
			throw new BookNotFoundException("No books found for category "+category);
		return books;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = bookRepository.findByPriceLessThan(price);
		if (books.isEmpty())
			throw new BookNotFoundException("No books found less than price "+price);
		return books;
	}

	@Override
	public List<Book> getByTitleContaining(String title) throws BookNotFoundException{
		List<Book> books = bookRepository.findByTitleContaining(title);
		if (books.isEmpty())
			throw new BookNotFoundException("No books found containing title "+title);
		return books;
	}

	@Override
	public List<Book> getByAuthorStarting(String author) throws BookNotFoundException{
		List<Book> books = bookRepository.findByAuthorStarting(author);
		if (books.isEmpty())
			throw new BookNotFoundException("No books found for author "+author);
		return books;
	}



	
}
