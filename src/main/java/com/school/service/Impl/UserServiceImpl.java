package com.school.service.Impl;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.entity.Professor;
import com.school.entity.Role;
import com.school.entity.RoleName;
import com.school.entity.Student;
import com.school.entity.User;
import com.school.exception.InternalServerErrorException;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.message.request.RoleForm;
import com.school.message.request.UserForm;
import com.school.repository.IProfessorRepository;
import com.school.repository.IRoleRepository;
import com.school.repository.IStudentRepository;
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

		Set<RoleForm> strRoles = userForm.getRole();
		Set<Role> roles = new HashSet<>();

		for (RoleForm roleForm : strRoles) {
			roles.add(utilRole(roleForm.getRole()));
		}
		
		utilUser(userForm,roles);
		
		return "SUCCES RESGISTRATION";

	}

	@Override
	public void utilUser(UserForm userForm,Set<Role> roles) throws SchoolException{
		
		final String username = userForm.getDni().toString();
		
		if (userRepository.existsByUsername(username)) {
			throw new NotFountException("USER_ALREADT_EXIST", "USER_ALREADT_EXIST");
		}
		if (userRepository.existsByDni(userForm.getDni())) {
			throw new NotFountException("DNI_ALREADT_EXIST", "DNI_ALREADT_EXIST");
		}
		
		User user = new User(username, encoder.encode(userForm.getPassword()), userForm.getName(),
				userForm.getLastname(), userForm.getMotherslastname(), userForm.getDatebirth(), userForm.getDni(),
				userForm.getSex(), userForm.getEst());
		
		user.setRoles(roles);
		
		try {
			userRepository.save(user);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
	}

	@Override
	public Role utilRole(String rolename) throws SchoolException {
		Role roles = new Role();
		switch (rolename) {
		case "admin":
			final Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: ROLE_ADMIN Role not find."));
			roles = adminRole;
			break;
		case "secret":
			final Role secretRole = roleRepository.findByName(RoleName.ROLE_SECRETARY)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: ROLE_SECRETARY Role not find."));
			roles = secretRole;
			break;
		case "prof":
			final Role profRole = roleRepository.findByName(RoleName.ROLE_PROFESSOR)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: ROLE_PROFESSOR Role not find."));
			roles = profRole;
			break;
		default:
			final Role studRole = roleRepository.findByName(RoleName.ROLE_STUDENT)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: ROLE_STUDENT Role not find."));
			roles = studRole;
			break;
		}
		return roles;
	}
	


	

}
