package com.trainspotting.stocker.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ArticleDto extends Article {
	private String author_nm;
	private MultipartFile file;
	private List<Tag> tagList;
	
	@Override
	public String toString() {
		return "ArticleDto [author_nm=" + author_nm + ", file=" + file + ", tagList=" + tagList + ", toString()="
				+ super.toString() + "]";
	}
	
	public String getAuthor_nm() {
		return author_nm;
	}
	public void setAuthor_nm(String author_nm) {
		this.author_nm = author_nm;
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
