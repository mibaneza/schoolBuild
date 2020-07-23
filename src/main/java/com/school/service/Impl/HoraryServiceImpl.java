package com.school.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dto.HoraryDto;
import com.school.entity.Horary;
import com.school.entity.Hour;
import com.school.exception.InternalServerErrorException;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.message.request.HoraryForm;
import com.school.repository.IHoraryRepository;
import com.school.repository.IHourRepository;
import com.school.service.IHoraryService;
import com.school.service.util.finddayweekname;


@Service
public class HoraryServiceImpl implements IHoraryService{
	private static final Logger LOGGER = LoggerFactory.getLogger(HoraryServiceImpl.class);
	
	@Autowired
	IHoraryRepository horaryRepository;
	
	@Autowired
	IHourRepository hourRepository;

	@Override
	@Transactional
	public String createHorary(HoraryForm horaryForm) throws SchoolException {
		Hour hour = hourRepository.findById(horaryForm.getHours())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "HORARY_NOT_FOUND"));
	  Horary horary = new Horary(finddayweekname.dayweek(horaryForm.getDayweek()),hour);
		try {
			horaryRepository.save(horary);
		}catch(final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return "Resgistro exitoso ";
	}

	@Override
	@Transactional(readOnly = true)
	public List<Horary> findAllHorary() throws SchoolException {
		List<Horary> horaryEntitys = new ArrayList<Horary>();
		try {
			horaryEntitys = horaryRepository.findAll();
			}catch(final Exception e) {
				LOGGER.error("INTERNAL_SERVER_ERROR");
				throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
			}
		return horaryEntitys;
	}

	@Override
	@Transactional(readOnly = true)
	public HoraryDto findbyhorary(Long id) throws SchoolException {
		Horary horary = new Horary();
			horary = horaryRepository.findById(id)
					.orElseThrow(() -> new NotFountException("SNOT-404-1", "HORARY_NOT_FOUND"));
					
		return new HoraryDto(horary);
	}

	@Override
	@Transactional
	public Horary updatehorary(HoraryForm horaryForm, Long id) throws SchoolException {
		Horary horary = null;
		horary = horaryRepository.findById(id)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "HORARY_NOT_FOUND"));
		Hour hour = hourRepository.findById(horaryForm.getHours())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "HORARY_NOT_FOUND"));
	 
		    horary.setDayweek(finddayweekname.dayweek(horaryForm.getDayweek()));
			horary.setHours(hour);
			

		try {
			horaryRepository.save(horary);
		}catch(final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return horary;
	}

	@Override
	public String deleteHorary(Long id) throws SchoolException {
		horaryRepository.findById(id)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "HORARY_NOT_FOUND"));

		try {
			  horaryRepository.deleteById(id);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
    
		return "DELECT SUCCESS";
	}



}
