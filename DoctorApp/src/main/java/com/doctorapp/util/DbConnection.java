package com.doctorapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	
	static Connection connection;
	
	public static Connection openConnection() {
		
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		String username = "hakona";
		String password = "Simeio@2023";
		try {
			connection = DriverManager.getConnection(url, username, password);
			//Statement statement = connection.createStatement();
			//statement.execute(Queries.CREATEQUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			if(connection!=null) 
				connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
