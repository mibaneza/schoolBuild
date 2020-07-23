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

import com.school.entity.Assistance;
import com.school.entity.Horary;
import com.school.exception.SchoolException;
import com.school.message.response.SchoolResponse;
import com.school.service.IAssistanceService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class AssistanceController {
	@Autowired
	IAssistanceService assistenceService;

	@RequestMapping(value = "assitence", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> createPostHorary(@Valid @RequestBody Assistance assistance) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				assistenceService.createAssistance(assistance));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "assitence", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<List<Assistance>> readGetHorary() throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				assistenceService.findAllAssistance());
	}
	
	@RequestMapping(value = "assitence", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<Assistance> updatePutHorary(@Valid @RequestBody Assistance assistance,@RequestParam Long id) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				assistenceService.updateAssistance(assistance, id));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "assitence", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> deleteHorary(@RequestParam Long id) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				assistenceService.deleteAssistance(id));
	}
}
