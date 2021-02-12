package com.trainspotting.stocker.article;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trainspotting.stocker.model.Article;
import com.trainspotting.stocker.model.ArticleDto;
import com.trainspotting.stocker.model.Tag;

@Mapper
public interface ArticleMapper {
	int insert(Article param);
	int insertArticleTag(ArticleDto param);
	ArticleDto selectArticle(ArticleDto param);
	List<ArticleDto> selectArticleAll(Tag filter);
	int archiveArticle(ArticleDto param);
	int updateArticle(ArticleDto param);
}
