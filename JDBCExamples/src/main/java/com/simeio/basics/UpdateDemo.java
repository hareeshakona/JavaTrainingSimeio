package com.simeio.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";

		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();) {

			System.out.println("Enter book Id");
			int bookId = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Enter price");
			double price = scanner.nextDouble();
			scanner.nextLine();
			// "update book set price = 900 where bookId =1"
			String sql = "update book set price = " + price + "where bookId = " + bookId;
			int result = statement.executeUpdate(sql);
			System.out.println("Updated " + result);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
