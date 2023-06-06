package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;

@Component
public class BookDetails {

	public List<Book> showBooks() {
		List<Book> books = Arrays.asList(
		new Book(1,"Java","Kathy","Tech",900),
		new Book(2,"Spring in Action","Kathy","Tech",900),
		new Book(3,"Head First Java","Robert","Tech",900),
		new Book(4,"How Things Work","Usborne","Kids",1500),
		new Book(5,"How Cars Work","Usborne Perry","Kids",1000),
		new Book(6,"Shopaholic","Sophie Kinsella","Fiction",500),
		new Book(7,"Easy Java","Kathy","Tech",1600));
		return books;
		
	}
}
