package com.school.service.util.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.school.message.request.CourseForm;
import com.school.entity.Course;

@Component("coursemapper")
public class CourseMapper {
	public static List<CourseForm> convertirCourseDtoList(List<Course> courses) {
		List<CourseForm> courseForm = new ArrayList<>();
		for (Course course : courses) {
			courseForm.add(new CourseForm(course.getCoursename()));
		}
		return courseForm;
	}
}