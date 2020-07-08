package com.school.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CourseForm {
	
    @NotBlank
    @Size(min = 3, max = 50)
    private String coursename;

    
	public CourseForm( String coursename) {

		this.coursename = coursename;
	}

	public CourseForm() {}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}


    
}
