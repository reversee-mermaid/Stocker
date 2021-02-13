package com.trainspotting.stocker.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainspotting.stocker.article.ArticleMapper;
import com.trainspotting.stocker.model.ArticleDto;
import com.trainspotting.stocker.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/signup")
	public void signup() {}
	
	@ResponseBody
	@PostMapping("/signup")
	public Map<String, Object> signup(@RequestBody User param) {
		Map<String, Object> json = new HashMap<>();
		json.put("code", service.signup(param));
		return json;
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@ResponseBody
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody User param, HttpSession session) {
		Map<String, Object> json = new HashMap<>();
		json.put("code", service.login(param, session));		
		return json;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
	
	@GetMapping("/gallery")
	public void gallery(Model model, HttpSession session) {
		List<ArticleDto> list = service.selectList(session);
		model.addAttribute("list", list);
	}

	@GetMapping("/profile")
	public void profile() {}
	
	@ResponseBody
	@PostMapping("/update")
	public Map<String, Object> update(@RequestBody User param, HttpSession session) {
		Map<String, Object> json = new HashMap<>();
		json.put("code", service.update(param, session));
		return json;
	}
}
