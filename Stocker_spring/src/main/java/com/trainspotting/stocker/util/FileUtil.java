package com.trainspotting.stocker.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("FileUtil")
public class FileUtil {
	
	private String getExtension(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}
	
	public String generateFileName(MultipartFile file, String title) {
		UUID uuid = UUID.randomUUID();
		String extension = getExtension(file.getOriginalFilename());
		
		return String.format("%s_%s.%s", uuid, title, extension);
	}
	
	public String getSavePath(HttpSession session, int user_id) {
		String path = "/resources/image/";
		String realPath = session.getServletContext().getRealPath(path);
		return realPath + user_id;
	}
	
	public void saveThumb(File origin_file, String savePath, int MAX) throws Exception {
		
		BufferedImage origin_image = ImageIO.read(origin_file);
		String extension = getExtension(origin_file.getName());

		File thumb_file = new File(savePath, "t_" + origin_file.getName());
		
		double origin_w = origin_image.getWidth();
		double origin_h = origin_image.getHeight();
		
		double ratio = (MAX / origin_w);
		
		int thumb_w = (int) (origin_w * ratio);
		int thumb_h = (int) (origin_h * ratio);
		
		BufferedImage thumb_image = new BufferedImage(thumb_w, thumb_h, BufferedImage.TYPE_3BYTE_BGR);
		
		Graphics2D graphic = thumb_image.createGraphics();
		Image image = origin_image.getScaledInstance(thumb_w, thumb_h, Image.SCALE_SMOOTH);
		graphic.drawImage(image, 0, 0, thumb_w, thumb_h, null);
		graphic.dispose();
		
		ImageIO.write(thumb_image, extension, thumb_file);
	}
	
	public void save(MultipartFile file, String savePath, String fileName) throws Exception {
	public void save(MultipartFile file, String savePath, String fileName, boolean createThumb) throws Exception {
		File origin_file = new File(savePath, fileName);
		file.transferTo(origin_file);
		
		saveThumb(origin_file, savePath, 600);
		if(createThumb) {
			saveThumb(origin_file, savePath, 600);
		}
	}
	}
}