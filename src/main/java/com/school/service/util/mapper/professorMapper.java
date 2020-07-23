package com.school.service.util.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.school.entity.Professor;
import com.school.message.response.ProfessorResponse;

@Component
public class professorMapper {
	
	public static List<ProfessorResponse> converterProfessor(List<Professor> professors){
		List<ProfessorResponse> professorResponse = new ArrayList<ProfessorResponse>();
		for(Professor professor : professors) {
			professorResponse.add(new ProfessorResponse(professor));
		}
		return professorResponse;
		
	}

}
