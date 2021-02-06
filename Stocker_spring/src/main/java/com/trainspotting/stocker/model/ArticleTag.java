package com.trainspotting.stocker.model;

public class ArticleTag {
	private int article_id;
	private int tag_id;
	
	public ArticleTag() {}
	
	public ArticleTag(int article_id, int tag_id) {
		this.article_id = article_id;
		this.tag_id = tag_id;
	}
	
	@Override
	public String toString() {
		return "ArticleTag [article_id=" + article_id + ", tag_id=" + tag_id + "]";
	}
	
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
}
