package com.simeio.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreInsertDemo {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";

		String sql = "insert into movie(movieId,moviename,genre,language) values(?,?,?,?)";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			preparedStatement.setInt(1, 3);
			preparedStatement.setString(2, "Tangled");
			preparedStatement.setString(3, "Kids");
			preparedStatement.setString(4, "English");
			boolean result = preparedStatement.execute();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
