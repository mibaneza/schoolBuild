package com.school.service.util.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.school.dto.CourseDto;
import com.school.entity.Course;

@Component("coursemapper")
public class CourseMapper {
	public static List<CourseDto> convertirCourseDtoList(List<Course> courses) {
		List<CourseDto> classroomDto = new ArrayList<>();
		for (Course course : courses) {
			classroomDto.add(new CourseDto(course));
		}
		return classroomDto;
	}
}
