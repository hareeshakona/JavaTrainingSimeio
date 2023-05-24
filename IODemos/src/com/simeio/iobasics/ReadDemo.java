package com.simeio.iobasics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadDemo {

	public static void main(String[] args) {
		
		InputStreamReader isReader = new InputStreamReader(System.in);
		
		BufferedReader bufferedReader = new BufferedReader(isReader);
		
		char ch = 0;
		try {
			ch = (char) bufferedReader.read();
			while(ch!= 'q') {
				System.out.println(ch);
				ch = (char) bufferedReader.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
