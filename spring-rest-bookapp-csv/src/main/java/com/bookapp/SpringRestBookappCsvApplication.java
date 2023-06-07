package com.bookapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.BookDTO;
import com.bookapp.service.IBookService;
import com.bookapp.util.CsvHelper;

@SpringBootApplication
public class SpringRestBookappCsvApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringRestBookappCsvApplication.class, args);
	}
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private CsvHelper csvHelper;

	@Override
	public void run(String... args) throws Exception {
		List<BookDTO> bookDtos = csvHelper.csvToList("books.csv");
		bookDtos.stream().forEach(bookDto -> bookService.addBook(bookDto));
		
	}

}
