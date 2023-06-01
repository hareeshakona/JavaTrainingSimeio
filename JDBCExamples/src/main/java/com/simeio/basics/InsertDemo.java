package com.simeio.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";

		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();) {
			for (int i = 0; i < 4; i++) {
				System.out.println("Enter book title name");
				String title = scanner.nextLine();
				System.out.println("Enter book Id");
				int bookId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter author");
				String author = scanner.nextLine();
				System.out.println("Enter price");
				double price = scanner.nextDouble();
				scanner.nextLine();
				// "insert into book values('How Things Work',1,'Usborne',1500)"
				String sql = "insert into book values ('" + title + "'," + bookId + ",'" + author + "'," + price + ")";
				int result = statement.executeUpdate(sql);
				System.out.println("Inserted " + result);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
