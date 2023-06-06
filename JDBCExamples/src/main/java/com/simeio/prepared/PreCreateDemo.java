package com.simeio.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreCreateDemo {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";

		String sql = "create table movie (movieId number primary key, moviename varchar(20), genre varchar(20), language varchar(20))";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
			boolean result = preparedStatement.execute();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
