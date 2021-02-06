package com.trainspotting.stocker.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ArticleDto extends Article {
	private MultipartFile file;
	private int[] tags;
	
	@Override
	public String toString() {
		return "ArticleDto [file=" + file + ", tags=" + tags + ", " + super.toString() + "]";
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int[] getTags() {
		return tags;
	}
	public void setTags(int[] tags) {
		this.tags = tags;
	}
}
