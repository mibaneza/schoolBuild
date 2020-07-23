package com.school.service;

import java.util.List;

import com.school.dto.ProfessorAllDto;
import com.school.entity.Professor;
import com.school.exception.SchoolException;
import com.school.message.request.FindIdForm;
import com.school.message.request.UserForm;
import com.school.message.response.ProfessorDetailResponse;
import com.school.message.response.ProfessorResponse;

public interface IProfessorService {

	public List<ProfessorAllDto> getProfessorAll()throws SchoolException;
	
	public ProfessorAllDto getProfessorNum(FindIdForm findidform)throws SchoolException;
	
	public String createProfessor(UserForm userForm) throws SchoolException;
}
