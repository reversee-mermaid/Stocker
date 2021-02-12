package com.trainspotting.stocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trainspotting.stocker.article.ArticleService;
import com.trainspotting.stocker.model.Tag;
import com.trainspotting.stocker.util.Preparer;

@Controller
public class IndexController {
	
	@Autowired
	private Preparer preparer;
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping(value={"/", "/home"})
	public String index() {
		return "redirect:/home/all";
	}

	@GetMapping("/home/{slug}")
	public String home(Model model, @PathVariable String slug) {
		Tag filter = new Tag();
		
		for(Tag tag : preparer.getTagList()) {
			if(tag.getSlug().equals(slug)) {
				filter = tag;
			}
		}
		
		model.addAttribute("list", articleService.selectList(filter));
		return "/home";
	}
	
	@GetMapping("/explore")
	public void explore() {}
	
	@GetMapping("/artists")
	public void artists() {}
	
	@GetMapping("/about")
	public void about() {}
}
