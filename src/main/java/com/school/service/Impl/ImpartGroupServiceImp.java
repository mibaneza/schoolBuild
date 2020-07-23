package com.school.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Classroom;
import com.school.entity.Course;
import com.school.entity.DayWeek;
import com.school.entity.Horary;
import com.school.entity.Hour;
import com.school.entity.Impart;
import com.school.entity.ImpartGroup;
import com.school.entity.Professor;
import com.school.exception.InternalServerErrorException;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.message.request.HoraryForm;
import com.school.message.request.ImpartGroupForm;
import com.school.repository.IClassroomRepository;
import com.school.repository.ICourseRepository;
import com.school.repository.IDayWeekRepository;
import com.school.repository.IDegreeRepository;
import com.school.repository.IHoraryRepository;
import com.school.repository.IHourRepository;
import com.school.repository.IImpartGroupRepository;
import com.school.repository.IImpartRepository;
import com.school.repository.IProfessorRepository;
import com.school.service.IImpartGroupService;
import com.school.service.util.finddayweekname;

@Service
public class ImpartGroupServiceImp implements IImpartGroupService{
	private static final Logger LOGGER = LoggerFactory.getLogger(ImpartGroupServiceImp.class);
	
	@Autowired
	IDegreeRepository degreeRepository;
	
	@Autowired
	ICourseRepository courseRepository;
	
	@Autowired
	IClassroomRepository classroomRepository;
	
	@Autowired
	IProfessorRepository professorRepository;
	
	@Autowired
	IHourRepository hourRepository;
	
	@Autowired
	IDayWeekRepository dayweekRepository;
	
	@Autowired
	IImpartRepository impartRepository;
	
	@Autowired
	IHoraryRepository horaryRepository;
	
	@Autowired
	IImpartGroupRepository impartGroupRepository;
	
	@Override
	public String createImpartGroupStude(ImpartGroupForm impartGroupForm) throws SchoolException {
		List<ImpartGroup> impartGroups = impartGroupRepository.findByFkdegree(impartGroupForm.getDegtree())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "Classroom_NOT_FOUND"));
	
		return "Resgistro exitoso ";
	}
	@Override
	public String createImpartGroupProfe(ImpartGroupForm impartGroupForm) throws SchoolException {
		ImpartGroup ig = new ImpartGroup();
		if (!degreeRepository.existsById(impartGroupForm.getDegtree())) {
			throw new NotFountException("DEGREE_NOT_EXIST", "DEGREE_NOT_EXIST");
		}
		
		ig.setFkdegree(impartGroupForm.getDegtree());
		
		
		Classroom classroom = classroomRepository.findBySection(impartGroupForm.getSection())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "Classroom_NOT_FOUND"));
		ig.setFkclassroom(classroom);
		Professor professor = professorRepository.findByNum(impartGroupForm.getNum())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "Professor_NOT_FOUND"));
		
		Course course= courseRepository.findByCoursename(impartGroupForm.getCoursename())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "Course_NOT_FOUND"));

		if (!impartRepository.existsByCourseidAndProfessorid(course,professor)) {
			impartRepository.save(new Impart(course,professor));

		}

		Impart impart= impartRepository.findByCourseidAndProfessorid(course,professor)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "Impart_NOT_FOUND"));
		
		ig.setImpart(impart);
		
		List <Horary> horary = new ArrayList<>();
		for(HoraryForm horarys : impartGroupForm.getHoraryForm()){
			Hour hour = hourRepository.findById(horarys.getHours())
					.orElseThrow(() -> new NotFountException("SNOT-404-1", "Hour_NOT_FOUND"));
			DayWeek dayweek =dayweekRepository.findById(horarys.getDayweek())
					.orElseThrow(() -> new NotFountException("SNOT-404-1", "Dayweek_NOT_FOUND"));
			Horary findhorary =horaryRepository.findByDayweekAndHours(dayweek,hour)
					.orElseThrow(() -> new NotFountException("SNOT-404-1", "Horary_NOT_FOUND"));
			horary.add(findhorary);
		}
		ig.setHorary(horary);
		
		try {
			impartGroupRepository.save(ig);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return "Resgistro exitoso ";
	}

	@Override
	public List<ImpartGroup> findAllImpartGroup() throws SchoolException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImpartGroup findbyImpartGroup(Long id) throws SchoolException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImpartGroup updateImpartGroup(ImpartGroupForm impartGroupForm, Long id) throws SchoolException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteImpartGroup(Long id) throws SchoolException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
