package com.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dto.ClassroomDto;
import com.school.entity.Classroom;
import com.school.exception.InternalServerErrorException;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.repository.IClassroomRepository;
import com.school.service.IClassroomService;
import com.school.service.util.mapper.ClassroomMapper;

@Service
public class ClassroomServiceImpl implements IClassroomService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassroomServiceImpl.class);

	@Autowired
	IClassroomRepository classroomRepository;

	@Override
	@Transactional
	public String createClassroom(ClassroomDto classroomDto) throws SchoolException {
		try {
			classroomRepository.save(new Classroom(classroomDto));
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return "Resgistro exitoso ";
	}

	@Override
	public List<ClassroomDto> findAllClassroom() throws SchoolException {
		List<Classroom> classroomEntitys = new ArrayList<Classroom>();
		try {
			classroomEntitys = classroomRepository.findAll();
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return ClassroomMapper.convertirClassroomDtoList(classroomEntitys);
	}

	

	@Override
	public ClassroomDto findbyClassroom(String section) throws SchoolException {
		Classroom classroomEntity = new Classroom();
		classroomEntity = classroomRepository.findBySection(section)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "HORARY_NOT_FOUND"));

		return new ClassroomDto(classroomEntity);
	}

	@Override
	public ClassroomDto updateClassroom(ClassroomDto classroomDto) throws SchoolException {
		Classroom classroomEntity = null;
		classroomEntity = classroomRepository.findBySection(classroomDto.getSection())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "CLASSROOM_NOT_FOUND"));

		classroomEntity.setCapacity(classroomDto.getCapacity());
		classroomEntity.setSection(classroomDto.getSection());
		classroomEntity.setVacancies(classroomDto.getVacancies());

		try {
			classroomRepository.save(classroomEntity);

		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return classroomDto;
	}

	@Override
	public String deleteClassroom(String section) throws SchoolException {
		classroomRepository.findBySection(section)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "HORARY_NOT_FOUND"));
		try {
			classroomRepository.deleteBySection(section);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}

		return "DELECT SUCCESS";
	}

}
