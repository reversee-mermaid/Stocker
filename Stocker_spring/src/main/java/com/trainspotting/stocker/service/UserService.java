package com.trainspotting.stocker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainspotting.stocker.mapper.UserMapper;
import com.trainspotting.stocker.model.User;
import com.trainspotting.stocker.util.SecurityUtil;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private SecurityUtil security;
	
	public int signup(User param) {
		
		User data = mapper.select(param);
		
		if(data != null) return -1;
		
		// password encryption
		String plain = param.getPw();
		String hash = security.getHashed(plain);
		
		param.setPw(hash);
		
		return mapper.insert(param);
	}
}
