package com.trainspotting.stocker.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ArticleDto extends Article {
	private MultipartFile file;
	private List<Tag> tagList;
	
	@Override
	public String toString() {
		return "ArticleDto [file=" + file + ", tags=" + tagList + ", " + super.toString() + "]";
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
}
