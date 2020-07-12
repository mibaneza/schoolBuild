package com.school.service;

import com.school.exception.SchoolException;
import com.school.message.request.LoginForm;
import com.school.message.response.JwtResponse;
import com.school.message.response.JwtUserResponse;

public interface ILoginService {
	public JwtUserResponse getJwtByLogin(LoginForm loginRequest) throws SchoolException;
}
