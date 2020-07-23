package com.school.dto;

import java.util.List;

import com.school.entity.Assistance;
import com.school.entity.Student;

public class CourseDetaiAllProflDto {
	private StudentDto student;
	private List<QualificationDto> quialification;
	private List<Assistance> assistance;
	
	
	
	public CourseDetaiAllProflDto(StudentDto student, List<QualificationDto> quialification, List<Assistance> assistance) {
		this.student = student;
		this.quialification = quialification;
		this.assistance = assistance;
	}
	
	public CourseDetaiAllProflDto() {}

	public StudentDto getStudent() {
		return student;
	}
	public void setStudent(StudentDto student) {
		this.student = student;
	}
	public List<QualificationDto> getQuialification() {
		return quialification;
	}
	public void setQuialification(List<QualificationDto> quialification) {
		this.quialification = quialification;
	}

	public List<Assistance> getAssistance() {
		return assistance;
	}

	public void setAssistance(List<Assistance> assistance) {
		this.assistance = assistance;
	}

}
