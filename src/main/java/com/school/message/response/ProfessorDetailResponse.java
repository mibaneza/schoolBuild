package com.school.message.response;

import java.util.List;

import com.school.dto.UserDto;


public class ProfessorDetailResponse {
	private String name;
	
	private Long num;
	
	private Long tutordegree;
	
	private UserDto userdto;
	
	private List<CourseResponse> courseResponse;
	
	
	
	public ProfessorDetailResponse(String name, Long num, Long tutordegree, UserDto userdto,
			List<CourseResponse> courseResponse) {
		this.name = name;
		this.num = num;
		this.tutordegree = tutordegree;
		this.userdto = userdto;
		this.courseResponse = courseResponse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public Long getTutordegree() {
		return tutordegree;
	}
	public void setTutordegree(Long tutordegree) {
		this.tutordegree = tutordegree;
	}
	public UserDto getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}
	public List<CourseResponse> getCourseResponse() {
		return courseResponse;
	}
	public void setCourseResponse(List<CourseResponse> courseResponse) {
		this.courseResponse = courseResponse;
	}

	

	
	
}
