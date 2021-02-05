package com.trainspotting.stocker.model;

public class User {
	private int id;
	private String email;
	private String nm;
	private String pw;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nm=" + nm + ", pw=" + pw + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
