package com.school.service;

import com.school.exception.SmsValidator;
import com.school.exception.SchoolException;
import com.school.message.request.CourseForm;
import com.school.message.request.CourseFormArray;

public interface ICourseService {
	
	String createCourse(final CourseForm courseForm) throws SchoolException;
	
	SmsValidator createCourseArray(final CourseFormArray courseFormArray) throws SchoolException;
	
	List<CourseForm> findAllCourse() throws SchoolException;
	
}
