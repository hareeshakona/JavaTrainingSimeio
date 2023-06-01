package com.simeio.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";
		String sql = "create table book(title varchar(20),bookId number primary key,author varchar(20),price number)";
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// create a connection object
			connection = DriverManager.getConnection(url, username, password);
			// create the statement object
			statement = connection.createStatement();
			System.out.println("table created " + statement.execute(sql));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
