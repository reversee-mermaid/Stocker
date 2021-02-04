package com.trainspotting.stocker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
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
