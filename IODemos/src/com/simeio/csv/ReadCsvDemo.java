package com.simeio.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsvDemo {

	public static void main(String[] args) {
		String line = "";
		String splitBy = ",";
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("csvdemo.csv"))) {
			while((line = bufferedReader.readLine()) != null) {
				String[] book = line.split(splitBy);
				System.out.println("Book - { Id - "+book[0]+", Title - "+book[1]+", Author - "+book[2]+", Price - "+book[3]+", Category - "+book[4]+" }" );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
