package com.trainspotting.stocker.model;

public class Article {
	private int id;
	private int author_id;
	private String title;
	private String caption;
	private String file_nm;
	private String regdate;
	private int archive;
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", author_id=" + author_id + ", title=" + title + ", caption=" + caption
				+ ", file_nm=" + file_nm + ", regdate=" + regdate + ", archive=" + archive + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getFile_nm() {
		return file_nm;
	}
	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getArchive() {
		return archive;
	}
	public void setArchive(int archive) {
		this.archive = archive;
	}
}
