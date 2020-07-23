package com.school.service;

import com.school.entity.Enrollment;
import com.school.entity.Student;
import com.school.exception.SchoolException;
import com.school.exception.SmsValidator;
import com.school.message.request.CourseDetailForm;


public interface ICourseDetailService {
	public SmsValidator createImpartGroupStudent(CourseDetailForm courseDetailForm) throws SchoolException;
	public void createEnrollmentStudent(CourseDetailForm courseDetailForm, Student fkstudent) throws SchoolException;

}
