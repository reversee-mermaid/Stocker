package com.trainspotting.stocker.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainspotting.stocker.model.User;
import com.trainspotting.stocker.service.UserService;

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
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
}
