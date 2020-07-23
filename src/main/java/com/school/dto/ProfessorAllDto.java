package com.school.dto;

import java.util.List;

public class ProfessorAllDto {
	private String name;
	private Long num;
	private List<ImpartDto> impart;
	
	public ProfessorAllDto(String name, Long num, List<ImpartDto> impart) {
		this.name = name;
		this.num = num;
		this.impart = impart;
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
	public List<ImpartDto> getImpart() {
		return impart;
	}
	public void setImpart(List<ImpartDto> impart) {
		this.impart = impart;
	}
    
	

}
