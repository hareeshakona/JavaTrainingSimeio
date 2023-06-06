package com.simeio.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreUpdateDemo {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";

		String sql = "update movie set language =? where movieId =?";
		
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

			System.out.println("Enter movieId");
			int movieId = scanner.nextInt();
			scanner.nextLine();		
			System.out.println("Enter language");
			String language = scanner.nextLine();			

			preparedStatement.setString(1, language);
			preparedStatement.setInt(2, movieId);
			int result = preparedStatement.executeUpdate();
			System.out.println("Updated " + result);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
