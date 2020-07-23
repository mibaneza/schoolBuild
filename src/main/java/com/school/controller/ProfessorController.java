package com.school.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.ProfessorAllDto;
import com.school.entity.Professor;
import com.school.exception.SchoolException;
import com.school.message.request.FindIdForm;
import com.school.message.request.ImpartGroupForm;
import com.school.message.request.UserForm;
import com.school.message.response.ProfessorDetailResponse;
import com.school.message.response.ProfessorResponse;
import com.school.message.response.SchoolResponse;
import com.school.service.IImpartGroupService;
import com.school.service.IProfessorService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class ProfessorController {
	
	@Autowired
	IProfessorService professorService;
	
	@Autowired
	IImpartGroupService impartGroupService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "find_all_professor", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<List<ProfessorAllDto>> findProfessorALL() throws SchoolException{
		return new SchoolResponse<List<ProfessorAllDto>>("Succes", String.valueOf(HttpStatus.OK), "OK",
				professorService.getProfessorAll());	
	} 
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "find_by_professor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<ProfessorAllDto> findProfessorNum(@RequestBody FindIdForm findidform) throws SchoolException{
		return new SchoolResponse<ProfessorAllDto>("Succes", String.valueOf(HttpStatus.OK), "OK",
				professorService.getProfessorNum(findidform));
		
	} 
	
	@RequestMapping(value = "asiegnar_professor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> asigrnarprofessor(@Valid @RequestBody ImpartGroupForm impartGroupForm) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				impartGroupService.createImpartGroupProfe(impartGroupForm));
	}  
	@RequestMapping(value = "professor", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> createprofessor(@Valid @RequestBody UserForm userForm) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				professorService.createProfessor(userForm));
	}  

}
