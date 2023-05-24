package com.simeio.iobasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TryWithResource {

	public static void main(String[] args) {

		try (FileInputStream fileInputStream = new FileInputStream("demo.txt");
				FileOutputStream fileOutputStream = new FileOutputStream("trial.txt");) {
			int ch = fileInputStream.read();
			while (ch != -1) {
				fileOutputStream.write(ch);
				ch = fileInputStream.read();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
