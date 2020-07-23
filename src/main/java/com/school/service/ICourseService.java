package com.school.service;

import com.school.exception.SmsValidator;

import java.util.List;

import com.school.dto.CourseDto;
import com.school.exception.SchoolException;
import com.school.message.request.CourseForm;
import com.school.message.request.CourseFormArray;

public interface ICourseService {
	
	String createCourse(final CourseForm courseForm) throws SchoolException;
	
	SmsValidator createCourseArray(final CourseFormArray courseFormArray) throws SchoolException;
	
	public List<CourseDto> findAllCourse() throws SchoolException;
	

}
