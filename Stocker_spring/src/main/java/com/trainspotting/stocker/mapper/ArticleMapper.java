package com.trainspotting.stocker.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.trainspotting.stocker.model.Article;
import com.trainspotting.stocker.model.ArticleDto;

@Mapper
public interface ArticleMapper {
	int insert(Article param);
	int insertArticleTag(ArticleDto param);
	ArticleDto selectArticle(ArticleDto param);
}
