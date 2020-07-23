package com.school.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Course;
import com.school.exception.InternalServerErrorException;
import com.school.exception.SmsValidator;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.message.request.CourseForm;
import com.school.message.request.CourseFormArray;
import com.school.repository.ICourseRepository;
import com.school.service.ICourseService;


@Service
public class CourseServiceImpl implements ICourseService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);
	

	
	@Autowired
	private ICourseRepository courseRepository;

	@Override
	public String createCourse(CourseForm courseForm) throws SchoolException {
		
		if(courseRepository.findByCoursename(courseForm.getCoursename()).isPresent()) {
			throw new NotFountException("COURSE_ALREADT_EXIST", "COURSE_ALREADT_EXIST");
		}
		Course course = new Course(courseForm.getCoursename());
		
		try {
			courseRepository.save(course);
			
		}catch(final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		String locators = courseForm.getCoursename();
		return locators;
	}

	@Override
	public SmsValidator createCourseArray(CourseFormArray courseFormArray) throws SchoolException {
		List<Course> listCourse = new ArrayList<>();
		List<Course> listAllCourse = new ArrayList<>();
		List<Object> listaOjbCourse = new ArrayList<>();
		listCourse = courseFormArray.getArraycoruse();
		String result = "Sign up failed";

		for (Course courso : listCourse) {
			String forCourse = courso.getCoursename();
			if (courseRepository.existsByCoursename(forCourse)) {
				listaOjbCourse.add(new CourseForm(courso.getCoursename()));
				forCourse = null;
			}
			if (forCourse != null) {
				listAllCourse.add(courso);
				result = "";
				result = "Successful registration";
			}
		}
		if (result == "Successful registration") {
			try {
				courseRepository.saveAll(listAllCourse);
			} catch (final Exception e) {
				LOGGER.error("INTERNAL_SERVER_ERROR", e);
				throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
			}
		}

		return new SmsValidator(result,listaOjbCourse);
	}
}


