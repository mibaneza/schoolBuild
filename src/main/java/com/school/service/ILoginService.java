package com.school.service;

import com.school.exception.SchoolException;
import com.school.message.request.LoginForm;
import com.school.message.response.JwtResponse;

public interface ILoginService {
	public JwtResponse getJwtByLogin(LoginForm loginRequest) throws SchoolException;
}
