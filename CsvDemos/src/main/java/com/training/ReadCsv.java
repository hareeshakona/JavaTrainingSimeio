package com.training;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCsv {

	public static void main(String[] args) {
		try (FileReader fileReader = new FileReader("employee.csv"); CSVReader csvReader = new CSVReader(fileReader);) {
			/*List<String[]> dataList = csvReader.readAll();
			dataList.forEach((dataArray) -> {
				for (String data : dataArray)
					System.out.println(data);
			});*/
			String[] line = null;
			while((line=csvReader.readNext())!=null) {
				Stream.of(line).forEach(System.out::println);			
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
