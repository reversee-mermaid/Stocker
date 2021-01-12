package com.stocker.test;

import java.util.List;

import com.stocker.dao.ArticleDao;
import com.stocker.dto.ArticleDto;

public class ArticleDao_test {

	public static void main(String[] args) {
		// TODO test - getArticle(id) method
		ArticleDto article = ArticleDao.select(2);
		System.out.println("Title : " + article.getTitle());
		
		// test - getAllArticle() method
		List<ArticleDto> list = ArticleDao.selectAll();
		
		for(ArticleDto dto : list) {
			System.out.println(dto);
		}
	}
}