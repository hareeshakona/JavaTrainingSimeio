package com.bookapp.util;

import com.bookapp.model.Book;

public class BookDetails {

	public static Book[] showBooks() {
		Book[] books = new Book[5];
		books[0]= new Book("Java","Kathy",1,900,"Tech");
		books[1]= new Book("Spring in Action","Kathy",2,900,"Tech");
		books[2]= new Book("Life After Life","Robert",3,900,"Fiction");
		books[3]= new Book("How Things Work","Usborne",4,1500,"Kids");
		books[4]= new Book("Shopaholic","Sophie Kinsella",5,800,"Fiction");
		return books;
		
	}
}
