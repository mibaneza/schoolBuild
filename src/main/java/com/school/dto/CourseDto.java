package com.school.dto;

import com.school.entity.Course;

public class CourseDto {

	private Long id;
	

	private String coursename;


	public CourseDto(Long id, String coursename) {
		this.id = id;
		this.coursename = coursename;
	}


	public CourseDto() {}


	public CourseDto(Course course) {
		this.id = course.getId();
		this.coursename = course.getCoursename();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCoursename() {
		return coursename;
	}


	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	

}
