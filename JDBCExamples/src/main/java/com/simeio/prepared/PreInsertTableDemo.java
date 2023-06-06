package com.simeio.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreInsertTableDemo {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";

		String sql = "insert into movie(movieId,moviename,genre,language) values(?,?,?,?)";

		try (Scanner sc = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			for (int i = 0; i < 4; i++) {
				System.out.println("Enter movieId");
				int movieId = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter movie name");
				String moviename = sc.nextLine();
				System.out.println("Enter genre");
				String genre = sc.nextLine();
				System.out.println("Enter language");
				String language = sc.nextLine();

				preparedStatement.setInt(1, movieId);
				preparedStatement.setString(2, moviename);
				preparedStatement.setString(3, genre);
				preparedStatement.setString(4, language);
				boolean result = preparedStatement.execute();
				System.out.println(result);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
