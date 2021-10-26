package com.mycompany.webapp.security;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
	private String memail;
	
	public CustomUserDetails(
			String mid, 
			String mpassword, 
			boolean menabled, 
			List<GrantedAuthority> mauthorities,
			String memail) {
		super(mid, mpassword, menabled, true, true, true, mauthorities);
		this.memail = memail;
	}
	
	public String getMemail() {
		return memail;
	}
}

