package com.school.message.request;
import java.util.ArrayList;
import java.util.List;


import com.school.entity.Course;

public class CourseFormArray {

	private List<Course> courses = new ArrayList<>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}



	
}
