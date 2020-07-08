package com.school.service;

import com.school.exception.SchoolException;
import com.school.message.request.UserForm;

public interface IUserService {
	String CreateUser(final UserForm userForm) throws SchoolException;
}
