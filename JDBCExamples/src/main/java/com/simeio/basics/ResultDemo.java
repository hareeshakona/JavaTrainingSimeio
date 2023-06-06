package com.simeio.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ResultDemo {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";

		String sql = "select * from book";
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sql);) {

			while (rs.next()) {
				String title = rs.getString("title");
				int bookId = rs.getInt("bookId");
				String author = rs.getString(3);
				double price = rs.getDouble("price");
				//System.out.println(title+"\t"+bookId+"\t"+author+"\t"+price);
				
				Book book = new Book(bookId,title,author,price);
				System.out.println(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
