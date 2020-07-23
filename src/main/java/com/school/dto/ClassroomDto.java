package com.school.dto;

import com.school.entity.Classroom;

public class ClassroomDto {
	
	private Long capacity;
	
	private String section;
	
	private Long vacancies;
	
	

	public ClassroomDto(Long capacity, String section, Long vacancies) {
		this.capacity = capacity;
		this.section = section;
		this.vacancies = vacancies;
	}

	public ClassroomDto(Classroom classroom) {
		this.capacity = classroom.getCapacity();
		this.section = classroom.getSection();
		this.vacancies = classroom.getVacancies();
	}

	public ClassroomDto() {}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Long getVacancies() {
		return vacancies;
	}

	public void setVacancies(Long vacancies) {
		this.vacancies = vacancies;
	}
	

}
