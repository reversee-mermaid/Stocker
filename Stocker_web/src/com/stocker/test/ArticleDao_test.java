package com.stocker.test;

import java.util.List;

import com.stocker.dao.ArticleDao;
import com.stocker.dto.ArticleDto;

public class ArticleDao_test {

	public static void main(String[] args) {
		// select(id)
		ArticleDto data = ArticleDao.select(2);
		System.out.println(data);
		
		// selectAll()
		List<ArticleDto> list = ArticleDao.selectAll();
		
		for(ArticleDto dto : list) {
			System.out.println(dto);
		}
	}
}