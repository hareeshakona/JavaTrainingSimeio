package com.simeio.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable {

	public static void main(String[] args) {
	
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";
		String sql = "insert into book values('How Things Work',1,'Usborne',1500)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();) {
			System.out.println("row inserted" + statement.execute(sql));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
