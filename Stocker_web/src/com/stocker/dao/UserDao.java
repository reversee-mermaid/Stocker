package com.stocker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.stocker.model.User;
import com.stocker.utils.DBUtils;

public class UserDao {
	//select
	
	//insert
	public static int insert(User dto) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_user (email, nm, pw) values (?, ?, ?)";
		
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getEmail());
			ps.setString(2, dto.getNm());
			ps.setString(3, dto.getPw());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConn(conn, ps);
		}
		
		return 0;
	}
	
	//update
	
	//delete
}
