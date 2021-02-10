package com.trainspotting.stocker.article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.trainspotting.stocker.model.ArticleDto;
import com.trainspotting.stocker.model.Tag;
import com.trainspotting.stocker.model.User;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	@GetMapping("/upload")
	public void upload() {}
	
	@ResponseBody
	@PostMapping("/upload")
	public Map<String, Object> upload(@RequestParam int[] tags, ArticleDto param, HttpSession session) {
		Map<String, Object> json = new HashMap<>();
		
		param.setTagList(generateTagList(tags));
		json.put("code", service.upload(param, session));
		json.put("id", param.getId());
		
		return json;
	}
	
	@GetMapping("/detail")
	public void detail(ArticleDto param, Model model) {}
	
	@ResponseBody
	@GetMapping("/detail/thumb")
	public Map<String, Object> thumb(ArticleDto param, HttpSession session) {
		
		ArticleDto article = service.detail(param);
		boolean editable = false;
		
		User current_user = (User) session.getAttribute("current_user");
		if(current_user != null) {
			editable = current_user.getId() == article.getAuthor_id();
		}
		
		Map<String, Object> json = new HashMap<>();
		json.put("article", article);
		json.put("editable", editable);
		
		return json;
	}
	
	private List<Tag> generateTagList(int[] tags) {
		List<Tag> list = new ArrayList<>();
		for(int tag_id : tags) {
			Tag tag = new Tag();
			tag.setId(tag_id);
			list.add(tag);
		}
		return list;
	}
}
