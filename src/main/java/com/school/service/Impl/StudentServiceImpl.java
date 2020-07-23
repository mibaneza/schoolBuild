package com.school.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.StudentDto;
import com.school.dto.Student.EnrollmentAllDto;
import com.school.dto.Student.StudentsOneAll;
import com.school.entity.Degree;
import com.school.entity.Enrollment;
import com.school.entity.Role;
import com.school.entity.Student;
import com.school.exception.InternalServerErrorException;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.message.request.FindIdForm;
import com.school.message.request.UserForm;
import com.school.repository.IDegreeRepository;
import com.school.repository.IRoleRepository;
import com.school.repository.IStudentRepository;
import com.school.service.IStudentService;
import com.school.service.IUserService;
import com.school.service.util.mapper.all.StudentSMapperAll;

@Service
public class StudentServiceImpl implements IStudentService{
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	IStudentRepository studentRepository;
	
    @Autowired
    IUserService userService;
        
    @Autowired
    IRoleRepository roleRepository;
    
	@Autowired
	IDegreeRepository degreeRepository;
	
	@Override
	public String createStudent(UserForm userForm) throws SchoolException {
	
		Set<Role> roles = new HashSet<>();
		roles.add(userService.utilRole("student"));
		
		userService.utilUser(userForm, roles);
		
		Student student = new Student(userForm.getName()+" "+userForm.getLastname(),
				userForm.getAttorney(),
				userForm.getDni(),
				userForm.getReference());

		try {
			studentRepository.save(student);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return "Registro exitoso";
	}

	@Override
	public List<Student> findAllStudent() throws SchoolException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentsOneAll findbyStudent(FindIdForm findidform) throws SchoolException {
		Student student = studentRepository.findByDni(findidform.getId())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "Student_NOT_FOUND"));
		
		
		StudentDto studentDto = new StudentDto(student);
		List<EnrollmentAllDto> enrollmentAllDto = new ArrayList<EnrollmentAllDto>();
		
		for (Enrollment enrollment : student.getEnrollment()) {
			Degree fkdegree = degreeRepository.findById(enrollment.getFkdegree())
			.orElseThrow(() -> new NotFountException("SNOT-404-1", "DEGREE_NOT_FOUND"));
			
			enrollmentAllDto.add(new EnrollmentAllDto(enrollment,fkdegree,
					StudentSMapperAll.coursedetailDtoAllList(enrollment.getCoursedetail())));
		}		
		
		return new StudentsOneAll(studentDto,enrollmentAllDto);
	}

	@Override
	public Student updateStudent(Student student, Long id) throws SchoolException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(Long id) throws SchoolException {
		// TODO Auto-generated method stub
		return null;
	}

}
