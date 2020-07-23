package com.school.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dto.ProfessorAllDto;
import com.school.dto.RoleDto;
import com.school.dto.UserDto;
import com.school.entity.Course;
import com.school.entity.Professor;
import com.school.entity.Role;
import com.school.entity.RoleName;
import com.school.entity.User;
import com.school.exception.InternalServerErrorException;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.message.request.FindIdForm;
import com.school.message.request.RoleForm;
import com.school.message.request.UserForm;
import com.school.message.response.ProfessorDetailResponse;
import com.school.message.response.ProfessorResponse;
import com.school.repository.IProfessorRepository;
import com.school.repository.IRoleRepository;
import com.school.repository.IUserRepository;
import com.school.service.IProfessorService;
import com.school.service.IUserService;
import com.school.service.util.mapper.professorMapper;
import com.school.service.util.mapper.all.ProfessorMapperAll;

@Service
public class ProfessorServiceImpl implements IProfessorService{
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorServiceImpl.class);
	    
	    @Autowired
	    IProfessorRepository professorRepository;
	    
	    @Autowired
	    IUserService userService;
	
	@Override
	public List<ProfessorAllDto> getProfessorAll() throws SchoolException {
		List<Professor> professors =  professorRepository.findAll();
		List<ProfessorAllDto> ProfessorsDto = new ArrayList<>();
		for(Professor professor : professors) {
			ProfessorsDto.add(ProfessorMapperAll.ProfessortDtoConverter(professor));
		}	
		return ProfessorsDto;
	}

	@Override
	public ProfessorAllDto getProfessorNum(FindIdForm findidform)throws SchoolException{
	
		Professor professor = professorRepository.findByNum(findidform.getId())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
	
		return  ProfessorMapperAll.ProfessortDtoConverter(professor);
	}

	@Override
	public String createProfessor(UserForm userForm) throws SchoolException {
		
		Set<Role> roles = new HashSet<>();
		roles.add(userService.utilRole("prof"));
				
		userService.utilUser(userForm, roles);
		Professor profe = new Professor(
				userForm.getName()+" "+userForm.getLastname(),
				userForm.getDni(),
				userForm.getTutordegree());
		
		try {
			professorRepository.save(profe);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		return "SUCCES RESGISTRATION";
	}

}
