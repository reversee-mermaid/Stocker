package com.stocker.test;

import java.sql.Connection;

import com.stocker.utils.DBUtils;

// Run as java application
public class DBUtils_test {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			conn = DBUtils.getConn();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				DBUtils.closeConn(conn);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
