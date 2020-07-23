package com.school.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.ClassroomDto;
import com.school.dto.HoraryDto;
import com.school.entity.Horary;
import com.school.exception.SchoolException;
import com.school.message.response.SchoolResponse;
import com.school.service.IClassroomService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class ClassroomController {
	
	@Autowired
	IClassroomService classroomService;
	
	@RequestMapping(value = "classroom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> createPostHorary(@Valid @RequestBody ClassroomDto classroomDto) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				classroomService.createClassroom(classroomDto));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "classroom", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<List<ClassroomDto>> readGetHorary() throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				classroomService.findAllClassroom());
	}
	
	@RequestMapping(value = "classroom", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<ClassroomDto> updatePutHorary(@Valid @RequestBody ClassroomDto classroomDto) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				classroomService.updateClassroom(classroomDto));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "classroom", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> deleteHorary(@RequestParam String section) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				classroomService.deleteClassroom(section));
	}

}
