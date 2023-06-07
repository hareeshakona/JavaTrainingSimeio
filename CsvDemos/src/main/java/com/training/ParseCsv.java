package com.training;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class ParseCsv {

	public static void main(String[] args) {
		String file="employee.csv";
		try {
			List<Employee> empBeans = new CsvToBeanBuilder<Employee>(new FileReader(file))
					.withType(Employee.class)
					.build()
					.parse();
			empBeans.forEach(System.out::println);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
