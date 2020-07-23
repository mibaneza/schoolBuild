package com.school.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.ProfessorAllDto;
import com.school.dto.Student.StudentsOneAll;
import com.school.exception.SchoolException;
import com.school.exception.SmsValidator;
import com.school.message.request.CourseDetailForm;
import com.school.message.request.FindIdForm;
import com.school.message.request.StudentForm;
import com.school.message.request.UserForm;
import com.school.message.response.SchoolResponse;
import com.school.service.ICourseDetailService;
import com.school.service.IStudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	@Autowired
	IStudentService studentService;
	
	@Autowired
	ICourseDetailService courseDetailService;
	
	@RequestMapping(value = "create_student", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> createPostHorary(@Valid @RequestBody UserForm userForm) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				studentService.createStudent(userForm));
	}
	
	@RequestMapping(value = "asiegnar_student_enr", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<SmsValidator> asigrnarstudent(@Valid @RequestBody CourseDetailForm courseDetailForm) throws SchoolException {
		return new SchoolResponse<SmsValidator>("Succes", String.valueOf(HttpStatus.OK), "OK",
				courseDetailService.createImpartGroupStudent(courseDetailForm));
	}  
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "find_by_student", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<StudentsOneAll> findProfessorNum(@RequestBody FindIdForm findidform) throws SchoolException{
		return new SchoolResponse<StudentsOneAll>("Succes", String.valueOf(HttpStatus.OK), "OK",
				studentService.findbyStudent(findidform));
		
	} 
}
