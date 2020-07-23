package com.school.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.dto.RoleDto;
import com.school.dto.UserDto;
import com.school.entity.Role;
import com.school.entity.RoleName;
import com.school.entity.User;
import com.school.exception.InternalServerErrorException;
import com.school.exception.SchoolException;
import com.school.message.request.LoginForm;
import com.school.message.response.JwtResponse;
import com.school.message.response.JwtUserResponse;
import com.school.repository.IUserRepository;
import com.school.security.jwt.JwtProvider;
import com.school.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    IUserRepository userRepository;
    
    @Autowired
    PasswordEncoder encoder;
     
    
	@Override
	public JwtUserResponse getJwtByLogin(LoginForm loginRequest) throws SchoolException {
	    String jwt = null;
	    Set<Role> rolesList = new HashSet<>();
	    Set<RoleDto> rolesDtoList = new HashSet<>();
		User user = userRepository.findByUsername(
				loginRequest.getUsername())
				.orElseThrow(() -> new RuntimeException("El username no existe"));
		rolesList = user.getRoles();
		for (Role role : rolesList ){
			switch(role.getName()) {
			case ROLE_ADMIN:
				rolesDtoList.add(new RoleDto(RoleName.ROLE_ADMIN));
				break;
			case ROLE_SECRETARY:
				rolesDtoList.add(new RoleDto(RoleName.ROLE_SECRETARY));
				break;
			case ROLE_PROFESSOR:
				rolesDtoList.add(new RoleDto(RoleName.ROLE_PROFESSOR));
				break;
			default:
				rolesDtoList.add(new RoleDto(RoleName.ROLE_STUDENT));
				break;
			}
		}
		UserDto userDto = new UserDto(user.getUsername(),user.getName(),user.getLastname(),
				user.getMotherslastname(),
				user.getDatebirth(),
				user.getDni(),
				user.getSex(),
				rolesDtoList);
		
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        ); 
        SecurityContextHolder.getContext().setAuthentication(authentication);
        jwt = jwtProvider.generateJwtToken(authentication);	     
        
        return new JwtUserResponse(userDto,new JwtResponse(jwt));
    }
		
	

}
