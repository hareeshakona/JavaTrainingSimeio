package com.simeio.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreResultSetDemo {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";

		String sql = "select * from movie where language = ?";
		
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				) {

			preparedStatement.setString(1, "Telugu");
			try(ResultSet rs = preparedStatement.executeQuery();) {
				
				while(rs.next()) {
					int movieId = rs.getInt("movieId");
					String moviename = rs.getString("moviename");
					String genre = rs.getString("genre");
					String language = rs.getString("language");
					System.out.println(movieId+"\t"+moviename+"\t"+genre+"\t"+language);
					
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
