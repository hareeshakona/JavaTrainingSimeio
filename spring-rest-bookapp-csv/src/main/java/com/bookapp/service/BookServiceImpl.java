package com.bookapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookConverter;
import com.bookapp.model.BookDTO;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {

	IBookRepository bookRepository;
	
	@Autowired
	private BookConverter bookConverter;
	
	public BookServiceImpl(IBookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public void addBook(BookDTO bookDto) {
		Book book = bookConverter.toEntity(bookDto);
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
	public List<BookDTO> getAll() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map(book -> bookConverter.toDto(book)).collect(Collectors.toList());
	}

	@Override
	public BookDTO getById(int bookId) throws BookNotFoundException{
		Book book = bookRepository.findById(bookId).orElseThrow(()->new BookNotFoundException("Invalid Id"));
		return bookConverter.toDto(book);
		//return book.orElseThrow(()->new BookNotFoundException("Invalid Id"));

	}

	@Override
	public List<BookDTO> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = bookRepository.findByCategory(category);
		if (books.isEmpty())
			throw new BookNotFoundException("No books found for category "+category);
		return books.stream().map(book -> bookConverter.toDto(book)).collect(Collectors.toList());
	}

	@Override
	public List<BookDTO> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = bookRepository.findByPriceLessThan(price);
		if (books.isEmpty())
			throw new BookNotFoundException("No books found less than price "+price);
		return books.stream().map(book -> bookConverter.toDto(book)).collect(Collectors.toList());
	}

	@Override
	public List<BookDTO> getByTitleContaining(String title, String category) throws BookNotFoundException{
		List<Book> books = bookRepository.findByTitleContaining(title, category);
		if (books.isEmpty())
			throw new BookNotFoundException("No books found containing title "+title);
		return books.stream().map(book -> bookConverter.toDto(book)).collect(Collectors.toList());
	}

	@Override
	public List<BookDTO> getByAuthorStarting(String author) throws BookNotFoundException{
		List<Book> books = bookRepository.findByAuthorStarting(author);
		if (books.isEmpty())
			throw new BookNotFoundException("No books found for author "+author);
		return books.stream().map(book -> bookConverter.toDto(book)).collect(Collectors.toList());
	}

}
