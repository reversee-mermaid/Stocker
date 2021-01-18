package com.stocker.model;

public class User {
	private int id;
	private String email;
	private String nm;
	private String pw;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("id : " + id + "\n");
		builder.append("email : " + email + "\n");
		builder.append("nm : " + nm + "\n");
		builder.append("pw : " + pw + "\n");
		
		return builder.toString();
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
