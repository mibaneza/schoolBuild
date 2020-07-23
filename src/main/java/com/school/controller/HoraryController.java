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

import com.school.dto.HoraryDto;
import com.school.entity.Horary;
import com.school.exception.SchoolException;
import com.school.message.request.HoraryForm;
import com.school.message.response.SchoolResponse;
import com.school.service.IHoraryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/")
public class HoraryController {
	
	@Autowired
	IHoraryService horaryService;

	@RequestMapping(value = "horary", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> createPostHorary(@Valid @RequestBody HoraryForm horaryForm) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				horaryService.createHorary(horaryForm));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "horary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<List<Horary>> readGetHorary() throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				horaryService.findAllHorary());
	}
	
	@RequestMapping(value = "horary", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<Horary> updatePutHorary(@Valid @RequestBody HoraryForm horaryForm,@RequestParam Long id) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				horaryService.updatehorary(horaryForm, id));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "horary", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SchoolResponse<String> deleteHorary(@RequestParam Long id) throws SchoolException {
		return new SchoolResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				horaryService.deleteHorary(id));
	}

}
