package com.trainspotting.stocker.model;

import org.springframework.web.multipart.MultipartFile;

public class UserDto extends User {
	MultipartFile file;
	String profile;
	
	@Override
	public String toString() {
		return "UserDto [file=" + file + ", profile=" + profile + ", toString()=" + super.toString() + "]";
	}
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
}
