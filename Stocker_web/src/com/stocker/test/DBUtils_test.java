package com.stocker.test;

import java.sql.Connection;

import com.stocker.utils.DBUtils;

// Run as java application
public class DBUtils_test {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			conn = DBUtils.getConn();
			System.out.println("connected");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// closeConn() 내부에서 예외처리를 하기 때문에
			// 사용하는 측에서 예외처리 불필요
			DBUtils.closeConn(conn, null);
			System.out.println("closed");
		}
	}
}
