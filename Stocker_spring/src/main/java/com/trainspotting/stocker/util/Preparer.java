package com.trainspotting.stocker.util;

import java.util.List;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trainspotting.stocker.mapper.TagMapper;
import com.trainspotting.stocker.model.Tag;

@Component("Preparer")
public class Preparer implements ViewPreparer {

	@Autowired
	private TagMapper tagMapper;
	
	private List<Tag> tagList;
	
	private List<Tag> getTagList() {
		if(tagList == null) {
			tagList = tagMapper.selectAll();
		}
		
		return tagList;		
	}
	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		
		Attribute tagList = new Attribute(getTagList());		
		attributeContext.putAttribute("tagList", tagList, true);
		
	}
	
}
