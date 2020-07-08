package com.school.controller;
//public class CourseController {}
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.exception.SmsValidator;
import com.school.exception.SchoolException;
import com.school.message.request.CourseForm;
import com.school.message.request.CourseFormArray;
import com.school.message.response.SchoolResponse;
import com.school.service.ICourseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class CourseController {
	
	@Autowired
	ICourseService courseService;
	
	@RequestMapping(value = "create_course", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> registerCourse(@Valid @RequestBody CourseForm courseForm) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				courseService.createCourse(courseForm));
	}
	
	@RequestMapping(value = "create_courses", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<SmsValidator> addAllCourse(@RequestBody CourseFormArray courseFormArray) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				courseService.createCourseArray(courseFormArray));
	}
}	