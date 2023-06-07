package com.bookapp.model;

import org.springframework.stereotype.Component;

@Component
public class BookConverter {

	public Book toEntity(BookDTO bookDTO) {
		Book book = new Book();
		book.setTitle(bookDTO.getTitle());
		book.setPrice(bookDTO.getPrice());
		book.setAuthor(bookDTO.getAuthor());
		book.setCategory(bookDTO.getCategory());
		book.setBookId(bookDTO.getBookId());
		return book;
	}
	
	//not all properties returned because this is sent to the front end
	public BookDTO toDto(Book book) {
		BookDTO bookDto = new BookDTO();
		bookDto.setTitle(book.getTitle());
		bookDto.setPrice(book.getPrice());
		bookDto.setAuthor(book.getAuthor());
		//bookDto.setCategory(book.getCategory());
		bookDto.setBookId(book.getBookId());
		return bookDto;
	}
}
