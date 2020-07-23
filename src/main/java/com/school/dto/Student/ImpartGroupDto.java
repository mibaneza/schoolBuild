package com.school.dto.Student;


import java.util.ArrayList;
import java.util.List;

import com.school.dto.ClassroomDto;
import com.school.dto.HoraryDto;

public class ImpartGroupDto {
	
	private String namefrofessor;
	
	private String namecourse;
	
	private ClassroomDto fkclassroom;
	
	private List<HoraryDto> fkhorary = new ArrayList<>() ;

	
	public ImpartGroupDto(String namefrofessor, String namecourse, ClassroomDto fkclassroom, List<HoraryDto> fkhorary) {
		this.namefrofessor = namefrofessor;
		this.namecourse = namecourse;
		this.fkclassroom = fkclassroom;
		this.fkhorary = fkhorary;
	}

	public String getNamefrofessor() {
		return namefrofessor;
	}

	public void setNamefrofessor(String namefrofessor) {
		this.namefrofessor = namefrofessor;
	}

	public String getNamecourse() {
		return namecourse;
	}

	public void setNamecourse(String namecourse) {
		this.namecourse = namecourse;
	}

	public ClassroomDto getFkclassroom() {
		return fkclassroom;
	}

	public void setFkclassroom(ClassroomDto fkclassroom) {
		this.fkclassroom = fkclassroom;
	}

	public List<HoraryDto> getFkhorary() {
		return fkhorary;
	}

	public void setFkhorary(List<HoraryDto> fkhorary) {
		this.fkhorary = fkhorary;
	}

}
