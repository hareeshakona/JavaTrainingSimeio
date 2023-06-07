package com.bookapp.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.BookDTO;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
public class CsvHelper {

	public List<BookDTO> csvToList(String fileName) {
		List<BookDTO> bookDtos = new ArrayList<>();
		try(FileReader reader = new FileReader(fileName);) {
			bookDtos = new CsvToBeanBuilder<BookDTO>(reader).withType(BookDTO.class).build().parse();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bookDtos;
	}
}
