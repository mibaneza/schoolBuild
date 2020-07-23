package com.school.service;

import java.util.Set;

import com.school.entity.Role;
import com.school.exception.SchoolException;
import com.school.message.request.UserForm;

public interface IUserService {
	String CreateUser(final UserForm userForm) throws SchoolException;
	void utilUser(final UserForm userForm, Set<Role> roles) throws SchoolException;
	Role utilRole(String rolename) throws SchoolException;
}
