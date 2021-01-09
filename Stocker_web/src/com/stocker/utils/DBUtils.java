package com.stocker.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {
	public static Connection getConn() throws Exception {
		String URL = "jdbc:mysql://localhost:3306/stocker?serverTimezone=UTC";
		String USER = "root";
		String PW = "root";
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		
		return conn;
	}
	
	public static void closeConn(Connection conn, PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (Exception e) {}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {}
		}
	}
	
	public static void closeConn(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {}
		}
		closeConn(conn, ps);
	}
}