package com.bookapp.service;

import com.bookapp.model.Book;

public interface IBookService {

	Book[] getAll();
	Book[] getByAuthor(String author);
	Book getById(int bookId);
	Book[] getByCategory(String category);
}
