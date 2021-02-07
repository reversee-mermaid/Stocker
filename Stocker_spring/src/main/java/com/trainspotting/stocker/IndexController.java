package com.trainspotting.stocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.trainspotting.stocker.article.ArticleService;

@Controller
public class IndexController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public void home() {}
	
	@GetMapping("/explore")
	public void explore() {}
	
	@GetMapping("/artists")
	public void artists() {}
	
	@GetMapping("/about")
	public void about() {}
}
