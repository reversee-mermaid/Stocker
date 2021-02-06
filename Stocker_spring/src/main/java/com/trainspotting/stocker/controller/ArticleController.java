package com.trainspotting.stocker.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.trainspotting.stocker.model.ArticleDto;
import com.trainspotting.stocker.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService service;
	
	@GetMapping("/upload")
	public void upload() {}
	
	@ResponseBody
	@PostMapping("/upload")
	public Map<String, Object> upload(ArticleDto param, HttpSession session) {
		Map<String, Object> json = new HashMap<>();
		json.put("code", service.upload(param, session));
		json.put("id", param.getId());
		return json;
	}
	
	//TODO get - detail
	//ArticleDto
}
