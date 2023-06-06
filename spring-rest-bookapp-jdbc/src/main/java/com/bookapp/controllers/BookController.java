package com.bookapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api")
public class BookController {
	
	IBookService bookService;

	public BookController(IBookService bookService) {
		super();
		this.bookService = bookService;
	}

	@PostMapping("/books")
	void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	@PutMapping("/books")
	void updateAllBook(@RequestBody Book book) {
		bookService.updateBook(book.getBookId(), book.getPrice());		
	}
	
	@PatchMapping("/books/bookId/{bookId}/price/{price}")
	void updateBook(@PathVariable("bookId") int bookId,@PathVariable("price") double price) {
		bookService.updateBook(bookId, price);
		
	}

	@DeleteMapping("/books/bookId/{bookId}")
	void deleteBook(@PathVariable("bookId") int bookId) {
		bookService.deleteBook(bookId);
	}

	@GetMapping("/books")
	List<Book> getAll() {
		return bookService.getAll();
	}

	@GetMapping("/books/id/{bookId}")
	Book getById(@PathVariable("bookId") int bookId) {
		return bookService.getById(bookId);
	}

	@GetMapping("/books/category/{category}")
	List<Book> getByCategory(@PathVariable("category") String category) {
		return bookService.getByCategory(category);
	}

	@GetMapping("/books/price/{price}")
	List<Book> getByPriceLessThan(@PathVariable("price") double price) {
		return bookService.getByPriceLessThan(price);
	}

	@GetMapping("/books/category/{category}/title/{title}")
	List<Book> getByTitleContaining(@PathVariable("title") String title, @PathVariable("category") String category) {
		return bookService.getByTitleContaining(title, category);
	}

	@GetMapping("/books/author")
	List<Book> getByAuthorStarting(@RequestParam("author") String author) {
		return bookService.getByAuthorStarting(author);
	}
}
