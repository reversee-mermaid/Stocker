package com.stocker.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	public static Connection getConn() throws Exception {
		String URL = "jdbc:mysql://localhost:3306/stocker?serverTimezone=UTC";
		String USER = "root";
		String PW = "root";
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		
		System.out.println("successfully connected");
		
		return conn;
	}
	
	//TODO add parameter - PreparedStatement ps, ResultSet rs
	public static void closeConn(Connection conn) throws Exception {
		if(conn != null) conn.close();
		System.out.println("successfully closed");
	}
}