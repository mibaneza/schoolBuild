package com.school.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.school.exception.SchoolException;
import com.school.message.request.LoginForm;
import com.school.message.response.JwtResponse;
import com.school.security.jwt.JwtProvider;
import com.school.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;
    
	@Override
	public JwtResponse getJwtByLogin(LoginForm loginRequest) throws SchoolException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        ); 

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return new JwtResponse(jwt);
    }
		
	

}
