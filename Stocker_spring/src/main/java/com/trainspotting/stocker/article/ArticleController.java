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
	public void detail(ArticleDto param, Model model) {
		model.addAttribute("article", service.detail(param));
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
