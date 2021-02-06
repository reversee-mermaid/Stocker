package com.trainspotting.stocker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trainspotting.stocker.model.Article;
import com.trainspotting.stocker.model.ArticleTag;

@Mapper
public interface ArticleMapper {
	int insert(Article param);
	int insertArticleTag(List<ArticleTag> list);
}
