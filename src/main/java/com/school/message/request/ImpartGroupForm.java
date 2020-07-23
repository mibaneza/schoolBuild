package com.school.message.request;

import java.util.ArrayList;
import java.util.List;

public class ImpartGroupForm {
	
	private String section;
	private String coursename;
	private Long num;
	private Long degtree;
	private List<HoraryForm> horaryForm = new ArrayList<>();

	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public List<HoraryForm> getHoraryForm() {
		return horaryForm;
	}
	public void setHoraryForm(List<HoraryForm> horaryForm) {
		this.horaryForm = horaryForm;
	}
	public Long getDegtree() {
		return degtree;
	}
	public void setDegtree(Long degtree) {
		this.degtree = degtree;
	}

}
