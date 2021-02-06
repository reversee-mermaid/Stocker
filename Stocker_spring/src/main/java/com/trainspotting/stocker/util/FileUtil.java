package com.trainspotting.stocker.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("FileUtil")
public class FileUtil {
	
	public String generateFileName(MultipartFile file, String title) {
		UUID uuid = UUID.randomUUID();
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		
		return String.format("%s_%s.%s", uuid, title, extension);
	}
	
	public String getSavePath(HttpSession session, int user_id) {
		String path = "/resources/image/";
		String realPath = session.getServletContext().getRealPath(path);
		return realPath + user_id;
	}
	
	public void save(MultipartFile file, String savePath, String fileName) throws Exception {
		file.transferTo(new File(savePath, fileName));
	}
}
