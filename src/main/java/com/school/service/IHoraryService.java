package com.school.service;

import java.util.List;

import com.school.dto.HoraryDto;
import com.school.entity.DayWeek;
import com.school.entity.Horary;
import com.school.exception.SchoolException;
import com.school.message.request.HoraryForm;

public interface IHoraryService {
	//Crud
	public String createHorary(HoraryForm horaryForm) throws SchoolException;
	public List<Horary> findAllHorary() throws SchoolException;
	public HoraryDto findbyhorary(Long id) throws SchoolException;
	public Horary updatehorary(HoraryForm horaryForm, Long id) throws SchoolException;
    public String deleteHorary(Long id) throws SchoolException;


}
