package com.trainspotting.stocker.tag;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.trainspotting.stocker.model.Tag;

@Mapper
public interface TagMapper {
	List<Tag> selectAll();
}
