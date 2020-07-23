package com.school.dto;

import com.school.entity.Student;

public class StudentDto {
	private String names;
	private Long dni;
	private String attorney;
	private String reference;
	
	public StudentDto(String names, Long dni, String attorney, String reference) {
		this.names = names;
		this.dni = dni;
		this.attorney = attorney;
		this.reference = reference;
	}
	
	public StudentDto(Student student) {
		this.names = student.getNames();
		this.dni = student.getDni();
		this.attorney = student.getAttorney();
		this.reference = student.getReference();
	}
	
	public StudentDto() {}
	
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getAttorney() {
		return attorney;
	}
	public void setAttorney(String attorney) {
		this.attorney = attorney;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
}
