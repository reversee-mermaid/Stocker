package com.stocker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stocker.dto.ArticleDto;
import com.stocker.utils.DBUtils;

public class ArticleDao {
	
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
			
			List<ArticleDto> list = new ArrayList<>();
			
			while(rs.next()) {
				ArticleDto dto = new ArticleDto();
				
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor_nm(rs.getString("author_nm"));
				dto.setFile_nm(rs.getString("file_nm"));

				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DBUtils.closeConn(conn, ps, rs);
		}
		
		return null;
	}
	
	public static ArticleDto select(int id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT "
				+ "title, caption, regdate, file_nm, nm AS author_nm "
				+ "FROM t_article AS a "
				+ "JOIN t_user AS u "
				+ "ON a.author_id = u.id "
				+ "WHERE a.id = ?";
		
		try {
			
			conn = DBUtils.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ArticleDto dto = new ArticleDto();
				
				dto.setId(id);
				dto.setTitle(rs.getString("title"));
				dto.setCaption(rs.getString("caption"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setFile_nm(rs.getString("file_nm"));
				dto.setAuthor_nm(rs.getString("author_nm"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DBUtils.closeConn(conn, ps, rs);
		}
		
		return null;
	}
	
	//TODO define - insert method
	
	//TODO define - update method
	
	//TODO define - delete method
}
