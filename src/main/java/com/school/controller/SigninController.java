package com.school.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.exception.SchoolException;
import com.school.message.request.LoginForm;
import com.school.message.response.JwtResponse;
import com.school.message.response.JwtUserResponse;
import com.school.message.response.SchoolResponse;
import com.school.service.ILoginService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class SigninController {
	
	@Autowired
	ILoginService loginService;
	
    
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<JwtUserResponse> loginUser(@Valid @RequestBody LoginForm loginRequest) throws SchoolException {
		return new SchoolResponse<JwtUserResponse>("Succes", String.valueOf(HttpStatus.OK), "OK",
				loginService.getJwtByLogin(loginRequest));
	} 

}
