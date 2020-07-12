package com.school.service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.school.entity.Role;
import com.school.entity.RoleName;
import com.school.entity.User;
import com.school.exception.InternalServerErrorException;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.message.request.RoleForm;
import com.school.message.request.UserForm;
import com.school.repository.IRoleRepository;
import com.school.repository.IUserRepository;
import com.school.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
    @Autowired
    IUserRepository userRepository;
    
    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    IRoleRepository roleRepository;

	@Override
	public String CreateUser(final UserForm userForm) throws SchoolException {
		   if(userRepository.existsByUsername(userForm.getUsername())) {
			 throw new NotFountException("USER_ALREADT_EXIST", "USER_ALREADT_EXIST");
	        }
		   if(userRepository.existsByDni(userForm.getDni())) {
			 throw new NotFountException("DNI_ALREADT_EXIST", "DNI_ALREADT_EXIST");
	        }
		   
	        User user = new User(
	        		userForm.getUsername(), encoder.encode(userForm.getPassword()), 
	        		userForm.getName(), userForm.getLastname(), userForm.getMotherslastname(),
	        		userForm.getDatebirth(), userForm.getDni(), userForm.getSex(), userForm.getEst());
	        
	        Set<RoleForm> strRoles = userForm.getRole();
	        Set<Role> roles = new HashSet<>();
	        
	       
	        
	        strRoles.forEach(role -> {
	        	switch(role.getRole()) {
		    		case "admin":
		    			final Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
		                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		    			roles.add(adminRole);
		    			
		    			break;
		    		case "pm":
		    			final Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
		                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		            	roles.add(pmRole);
		            	
		    			break;
		    		default:
		    			final Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
		                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		        		roles.add(userRole);        			
	        	}
	        });
	        
	        user.setRoles(roles);
	        try {
	        	 userRepository.save(user);
	        }catch(final Exception e) {
	        	LOGGER.error("INTERNAL_SERVER_ERROR", e);
	        	throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
	        }
	        String locator = userForm.getUsername();
	       return  locator;
	   
	}

}
