package com.trainspotting.stocker.user;

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
		
		User data = mapper.select(param);
		
		if(data == null) return -1;
		
		String plain = param.getPw();
		String hashed = data.getPw();
		
		if(!security.checkPw(plain, hashed)) return -2;
		
		data.setPw(null);
		session.setAttribute("current_user", data);
		return 1;
	}
	
	public List<ArticleDto> selectList(HttpSession session) {
		User current_user = (User) session.getAttribute("current_user");
		return mapper.selectArticleAll(current_user);
	}
	
	public int update(User param, HttpSession session) {
		try {
			User current_user = (User) session.getAttribute("current_user");
			param.setId(current_user.getId());
			
			if(param.getNm() != null && !param.getNm().equals(current_user.getNm())) {
				int result = mapper.update(param);
				if(result == 1) {
					current_user.setNm(param.getNm());
				}
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int update(UserDto param, HttpSession session) {
		User current_user = (User) session.getAttribute("current_user");
		
		try {
			String savePath = util.getSavePath(session, current_user.getId());

			if(param.getFile() != null) {
				MultipartFile file = param.getFile();
				
				String extension = util.getExtension(file.getOriginalFilename());
				String filename = String.format("%s.%s", "profile", extension);
				
				util.updateProfile(file, savePath, filename);
				
				param.setProfile(filename);
				param.setId(current_user.getId());
				mapper.updateProfile(param);

				current_user.setProfile(filename);

			} else {
				util.deleteProfile(savePath);
				mapper.updateProfile(param);
				current_user.setProfile(null);
			}
			
			return 1;
		} catch (Exception e) {}
		
		return 0;
	}
}
