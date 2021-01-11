package com.stocker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.stocker.dto.ArticleDto;
import com.stocker.utils.DBUtils;

public class ArticleDao {
	//TODO define - selectAll method
	public static List<ArticleDto> selectAll() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT "
				+ "a.id, title, nm AS author_nm, file_nm "
				+ "FROM t_article AS a "
				+ "JOIN t_user AS u "
				+ "ON author_id = u.id "
				+ "ORDER BY regdate DESC";
		
		try {
			conn = DBUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("title"));
				System.out.println(rs.getString("author_nm"));
				System.out.println(rs.getString("file_nm"));
				//TODO add ArticleDto to List
			}
			//TODO return - List<ArticleDto>
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DBUtils.closeConn(conn, ps, rs);
		}
		
		return null;
	}
	
	//TODO define - select method
	
	//TODO define - insert method
	
	//TODO define - update method
	
	//TODO define - delete method
}
