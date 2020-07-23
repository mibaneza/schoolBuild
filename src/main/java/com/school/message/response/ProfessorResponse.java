package com.school.message.response;

import com.school.dto.UserDto;
import com.school.entity.Professor;
import com.school.entity.User;

public class ProfessorResponse {
	

	private String name;
	
	private Long num;
	
	private Long tutordegree;
	
	

	public ProfessorResponse(String name, Long num, Long tutordegree) {
		this.name = name;
		this.num = num;
		this.tutordegree = tutordegree;
	}

	public ProfessorResponse(Professor professor) {
		this.name = professor.getName();
		this.num = professor.getNum();
		this.tutordegree = professor.getTutordegree();
	}
	public ProfessorResponse(Professor professor, User user) {
		
		this.name = professor.getName();
		this.num = professor.getNum();
		this.tutordegree = professor.getTutordegree();
		
	}
	public ProfessorResponse() {}


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
	
	
}
