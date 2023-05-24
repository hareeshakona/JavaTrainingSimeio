package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import com.bookapp.model.Book;

public class BookDetails {

	public static List<Book> showBooks() {
		List<Book> books = Arrays.asList(
		new Book("Java","Kathy",1,900,"Tech"),
		new Book("Spring in Action","Kathy",2,900,"Tech"),
		new Book("Life After Life","Robert",3,900,"Fiction"),
		new Book("How Things Work","Usborne",4,1500,"Kids"),
		new Book("Shopaholic","Sophie Kinsella",5,800,"Fiction"));
		return books;
		
	}
}
