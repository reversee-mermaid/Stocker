package com.stocker.dto;

import com.stocker.model.Article;

public class ArticleDto extends Article {
	private String author_nm;
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\t Article \n");
		str.append("id: " + getId() + "\n");
		str.append("author_id: " + getAuthor_id() + "\n");
		str.append("author_nm: " + author_nm + "\n");
		str.append("title: " + getTitle() + "\n");
		str.append("caption: " + getCaption() + "\n");
		str.append("file_nm: " + getFile_nm() + "\n");
		str.append("regdate: " + getRegdate() + "\n");
		
		return str.toString();
	}
	
	public String getAuthor_nm() {
		return author_nm;
	}
	public void setAuthor_nm(String author_nm) {
		this.author_nm = author_nm;
	}
}