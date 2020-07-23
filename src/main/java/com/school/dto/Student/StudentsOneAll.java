package com.school.dto.Student;

import java.util.ArrayList;
import java.util.List;

import com.school.dto.StudentDto;

public class StudentsOneAll {
	StudentDto student;
	List<EnrollmentAllDto> EnrollmentDto = new ArrayList<>();
	
	public StudentsOneAll(StudentDto student, List<EnrollmentAllDto> enrollmentDto) {
		this.student = student;
		EnrollmentDto = enrollmentDto;
	}
	public StudentDto getStudent() {
		return student;
	}
	public void setStudent(StudentDto student) {
		this.student = student;
	}
	public List<EnrollmentAllDto> getEnrollmentDto() {
		return EnrollmentDto;
	}
	public void setEnrollmentDto(List<EnrollmentAllDto> enrollmentDto) {
		EnrollmentDto = enrollmentDto;
	}
	
}
