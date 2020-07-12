package com.school.message.response;

import java.util.Date;

import com.school.dto.UserDto;

public class JwtUserResponse {
	private UserDto user;	
	private JwtResponse jwt;
	
	
	public JwtUserResponse(UserDto user, JwtResponse jwt) {
		this.user = user;
		this.jwt = jwt;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public JwtResponse getJwt() {
		return jwt;
	}
	public void setJwt(JwtResponse jwt) {
		this.jwt = jwt;
	}
	
	
	

}
