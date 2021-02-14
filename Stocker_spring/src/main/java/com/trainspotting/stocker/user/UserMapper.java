package com.trainspotting.stocker.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trainspotting.stocker.model.ArticleDto;
import com.trainspotting.stocker.model.User;
import com.trainspotting.stocker.model.UserDto;

@Mapper
public interface UserMapper {
	int insert(User param);
	UserDto select(User param);
	List<ArticleDto> selectArticleAll(User param);
	int update(User param);
}
