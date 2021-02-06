package com.trainspotting.stocker.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainspotting.stocker.mapper.ArticleMapper;
import com.trainspotting.stocker.model.*;
import com.trainspotting.stocker.util.FileUtil;

@Service
public class ArticleService {
	
	@Autowired
	private FileUtil util;
	
	@Autowired
	private ArticleMapper mapper;
	
	public int upload(ArticleDto param, HttpSession session) {	
		
		User current_user = (User) session.getAttribute("current_user");
		
		try {
			// file upload
			String savePath = util.getSavePath(session, current_user.getId());
			String fileName = util.generateFileName(param.getFile(), param.getTitle());
			util.save(param.getFile(), savePath, fileName);

			// insert into t_article
			param.setAuthor_id(current_user.getId());
			param.setFile_nm(fileName);
			mapper.insert(param);
			
			// insert t_article_tag
			mapper.insertArticleTag(param);
			
			return 1;
			
		} catch (Exception e) {}
		
		return 0;
	};
}
