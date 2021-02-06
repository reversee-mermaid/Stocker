package com.trainspotting.stocker.model;

public class Tag {
	private int id;
	private int order_no;
	private String nm;
	private String slug;
	
	@Override
	public String toString() {
		return "Tag [id=" + id + ", order_no=" + order_no + ", nm=" + nm + ", slug=" + slug + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
}
