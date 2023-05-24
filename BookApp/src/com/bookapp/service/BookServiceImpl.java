package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public Book[] getAll() {
		return BookDetails.showBooks();
	}

	@Override
	public Book[] getByAuthor(String author) {
		Book[] allbooks = getAll();
		int count = 0;
		for (Book book : allbooks) {
			if (book.getAuthor().equals(author)) count++;			
		}
		Book[] booksbyauthor = new Book[count];
		count = 0;
		for (Book book : allbooks) {
			if (book.getAuthor().equals(author)) 
			{
				booksbyauthor[count]=book;
				count++;
			}
		}
		return booksbyauthor;
		
	}

	@Override
	public Book getById(int bookId) {
		
		Book[] allbooks = getAll();
		Book bookbyid = null;
		for (Book book : allbooks) {
			if (book.getBookId().intValue() == bookId) 
				{
				bookbyid = book;
				};			
		}
		
		return bookbyid;		
		
	}

	@Override
	public Book[] getByCategory(String category) {
		
		Book[] allbooks = getAll();
		int count = 0;
		for (Book book : allbooks) {
			if (book.getCategory().equals(category)) count++;			
		}
		Book[] booksbycategory = new Book[count];
		count = 0;
		for (Book book : allbooks) {
			if (book.getCategory().equals(category)) 
			{
				booksbycategory[count]=book;
				count++;
			}
		}
		return booksbycategory;

		
	}

}
