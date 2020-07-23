package com.school.dto;

import java.util.List;

import com.school.entity.Course;

public class ImpartDto {
	private String namecourse;
	private List<ImpartGruopDto> impartgroup;
	
	
	
	public ImpartDto(String namecourse, List<ImpartGruopDto> impartgroup) {
		this.namecourse = namecourse;
		this.impartgroup = impartgroup;
	}
	public ImpartDto(Course course, List<ImpartGruopDto> impartgroup) {
		this.namecourse = course.getCoursename();
		this.impartgroup = impartgroup;
	}
	
	public ImpartDto() {}

	public String getNamecourse() {
		return namecourse;
	}
	public void setNamecourse(String namecourse) {
		this.namecourse = namecourse;
	}
	public List<ImpartGruopDto> getImpartgroup() {
		return impartgroup;
	}
	public void setImpartgroup(List<ImpartGruopDto> impartgroup) {
		this.impartgroup = impartgroup;
	}

}
