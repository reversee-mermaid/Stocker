package com.trainspotting.stocker.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {
	
	public String getHashed(String plain) {
		return BCrypt.hashpw(plain, BCrypt.gensalt());
	}
	
	public boolean checkPw(String plain, String hashed) {
		return BCrypt.checkpw(plain, hashed);
	}
}
