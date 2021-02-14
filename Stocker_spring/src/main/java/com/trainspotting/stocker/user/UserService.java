package com.trainspotting.stocker.user;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.trainspotting.stocker.model.ArticleDto;
import com.trainspotting.stocker.model.User;
import com.trainspotting.stocker.model.UserDto;
import com.trainspotting.stocker.util.FileUtil;
import com.trainspotting.stocker.util.SecurityUtil;

@Service
public class UserService {


	@Autowired
	private FileUtil util;
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private SecurityUtil security;
	
	public int signup(User param) {
		
		if(mapper.select(param) != null) return -1;
		
		// password encryption
		String plain = param.getPw();
		String hash = security.getHashed(plain);
		param.setPw(hash);
		
		return mapper.insert(param);
	}
	
	public int login(User param, HttpSession session) {
		
		UserDto data = mapper.select(param);
		
		if(data == null) return -1;
		
		String plain = param.getPw();
		String hashed = data.getPw();
		
		if(!security.checkPw(plain, hashed)) return -2;
		
		data.setPw(null);
		
		String savePath = util.getSavePath(session, data.getId());
		data.setProfile(util.getProfile(savePath));
		session.setAttribute("current_user", data);
		
		return 1;
	}
	
	public List<ArticleDto> selectList(HttpSession session) {
		User current_user = (User) session.getAttribute("current_user");
		return mapper.selectArticleAll(current_user);
	}
	
	public int update(UserDto param, HttpSession session) {
		try {
			UserDto current_user = (UserDto) session.getAttribute("current_user");
			if(current_user == null) return -1;
			
			param.setId(current_user.getId());

			if(param.getNm() != null && !param.getNm().equals(current_user.getNm())) {
				if(mapper.update(param) != 1) return 0;
				current_user.setNm(param.getNm());
			}
			
			String savePath = util.getSavePath(session, param.getId());
			
			if(param.getFile() != null) {
				String extension = util.getExtension(param.getFile().getOriginalFilename());
				String fileName = String.format("%s.%s", "profile", extension);
				
				util.updateProfile(param.getFile(), savePath, fileName);
				current_user.setProfile(fileName);
			} else {
				util.deleteProfile(savePath);
				current_user.setProfile(null);
			}
			
			return 1;
		} catch (Exception e) {}
		
		return 0;
	}
}
