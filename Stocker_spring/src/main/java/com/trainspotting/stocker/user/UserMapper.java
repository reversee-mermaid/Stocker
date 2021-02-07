package com.trainspotting.stocker.user;

import org.apache.ibatis.annotations.Mapper;

import com.trainspotting.stocker.model.User;

@Mapper
public interface UserMapper {
	int insert(User param);
	User select(User param);
}
