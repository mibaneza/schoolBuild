package com.school.service;

import java.util.List;

import com.school.entity.Assistance;
import com.school.exception.SchoolException;

public interface IAssistanceService {
	//Crud
	public String createAssistance(Assistance assistance) throws SchoolException;
	public List<Assistance> findAllAssistance() throws SchoolException;
	public Assistance findbyAssistance(Long id) throws SchoolException;
	public Assistance updateAssistance(Assistance assistance, Long id) throws SchoolException;
    public String deleteAssistance(Long id) throws SchoolException;

}


