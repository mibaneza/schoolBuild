package com.school.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Assistance;
import com.school.exception.InternalServerErrorException;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.repository.IAssistanceRepository;
import com.school.service.IAssistanceService;

@Service
public class AssistanceServiceImpl implements IAssistanceService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AssistanceServiceImpl.class);

	@Autowired
	IAssistanceRepository assistanceRepository;

	@Override
	public String createAssistance(Assistance assistance) throws SchoolException {
		try {
			assistanceRepository.save(assistance);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return "Resgistro exitoso ";
	}

	@Override
	public List<Assistance> findAllAssistance() throws SchoolException {
		List<Assistance> AssistanceyEntitys = new ArrayList<Assistance>();
		try {
			AssistanceyEntitys = assistanceRepository.findAll();
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return AssistanceyEntitys;
	}

	@Override
	public Assistance findbyAssistance(Long id) throws SchoolException {
		Assistance assistance = new Assistance();
		assistance = assistanceRepository.findById(id)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "ASSISTENCE_NOT_FOUND"));
		return assistance;
	}

	@Override
	public Assistance updateAssistance(Assistance assistanceResponse, Long id) throws SchoolException {
		Assistance assistance = null;
		assistance = assistanceRepository.findById(id)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "ASSISTENCE_NOT_FOUND"));

		assistance.setLack(assistanceResponse.getLack());
		assistance.setAssistance(assistanceResponse.getAssistance());
		assistance.setDelay(assistanceResponse.getDelay());
		;

		try {
			assistanceRepository.save(assistance);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return assistance;
	}

	@Override
	public String deleteAssistance(Long id) throws SchoolException {
		assistanceRepository.findById(id).orElseThrow(() -> new NotFountException("SNOT-404-1", "ASSISTENCE_NOT_FOUND"));

		try {
			assistanceRepository.deleteById(id);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}

		return "DELECT SUCCESS";
	}

}
