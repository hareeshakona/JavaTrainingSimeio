package com.simeio.iobasics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class ReadAndWriteToFile {

	public static void main(String[] args) {

		FileReader filereader = null;
		FileOutputStream fileOutputStream = null;
		try {

			filereader = new FileReader("demo.txt");

			fileOutputStream = new FileOutputStream("demo1.txt", true);

			int ch = filereader.read();

			while (ch != -1) {
				fileOutputStream.write(ch);
				ch = filereader.read();
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null)
					fileOutputStream.close();
				if (filereader != null)
					filereader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
