package com.simeio.iobasics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileWrite {

	public static void main(String[] args) {

		InputStreamReader isReader = new InputStreamReader(System.in);

		BufferedReader bufferedReader = new BufferedReader(isReader);

		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("demo.txt", true);

			char ch = (char) bufferedReader.read();
			while (ch != 'q') {
				fileOutputStream.write(ch);
				ch = (char) bufferedReader.read();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null)
					fileOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
