package com.school.dto.Student;

import java.util.List;
import com.school.entity.Degree;
import com.school.entity.Enrollment;

public class EnrollmentAllDto {

	private String registrationnumber;
	
	private String date;
	
	private String observations;
	
	private Degree fkdegree;
	
	private List<CourseDetailDto> coursedetailDto ;
	
	public EnrollmentAllDto(String registrationnumber, String date, String observations, Degree fkdegree,
			List<CourseDetailDto> coursedetailDto) {
		this.registrationnumber = registrationnumber;
		this.date = date;
		this.observations = observations;
		this.fkdegree = fkdegree;
		this.coursedetailDto = coursedetailDto;
	}
	
	public EnrollmentAllDto(Enrollment enrollments,Degree fkdegree, List<CourseDetailDto> coursedetailDto) {
		this.registrationnumber = enrollments.getRegistrationnumber();
		this.date = enrollments.getDate();
		this.observations = enrollments.getObservations();
		this.fkdegree = fkdegree;
		this.coursedetailDto = coursedetailDto;
	}
	
	public String getRegistrationnumber() {
		return registrationnumber;
	}

	public void setRegistrationnumber(String registrationnumber) {
		this.registrationnumber = registrationnumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Degree getFkdegree() {
		return fkdegree;
	}

	public void setFkdegree(Degree fkdegree) {
		this.fkdegree = fkdegree;
	}

	public List<CourseDetailDto> getCoursedetailDto() {
		return coursedetailDto;
	}

	public void setCoursedetailDto(List<CourseDetailDto> coursedetailDto) {
		this.coursedetailDto = coursedetailDto;
	}

}
