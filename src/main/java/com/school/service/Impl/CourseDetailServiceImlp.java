package com.school.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.CourseDetail;
import com.school.entity.Enrollment;
import com.school.entity.ImpartGroup;
import com.school.entity.Student;
import com.school.exception.InternalServerErrorException;
import com.school.exception.NotFountException;
import com.school.exception.SchoolException;
import com.school.exception.SmsValidator;
import com.school.message.request.CourseDetailForm;
import com.school.message.request.CourseForm;
import com.school.repository.ICourseDetailRepository;
import com.school.repository.IEnrollmentRepository;
import com.school.repository.IImpartGroupRepository;
import com.school.repository.IStudentRepository;
import com.school.service.ICourseDetailService;
import com.school.service.util.UtilsSchool;

@Service
public class CourseDetailServiceImlp implements ICourseDetailService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CourseDetailServiceImlp.class);
	
	@Autowired
	IImpartGroupRepository impartGroupRepository;
	
	@Autowired
	IStudentRepository studentRepository;
	
	@Autowired
	IEnrollmentRepository enrollmentRepository;
	
	@Autowired
	ICourseDetailRepository courseDetailRepository;
	
	@Override
	public SmsValidator createImpartGroupStudent(CourseDetailForm courseDetailForm) throws SchoolException {
		
		
		Student student = studentRepository.findByDni(courseDetailForm.getDni())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "Student_NOT_FOUND"));
		
		createEnrollmentStudent(courseDetailForm,student);
		
		//if (!enrollmentRepository.existsByFkstudentAndDate(student,courseDetailForm.getDate())) {
		//	throw new NotFountException("Enrollment_NOT_FOUND", "Enrollment_NOT_FOUND");
		//}
		
		Enrollment enrollment = enrollmentRepository.findByFkstudentAndDate(student,courseDetailForm.getDate())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "Enrollment_NOT_FOUND"));
		
		List<ImpartGroup> impartGroups = impartGroupRepository.findByFkdegree(enrollment.getFkdegree())
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "ImpartGroupNOT_FOUND"));
		
		List<CourseDetail> courseDetail = new ArrayList<>();
		
		List<Object> listaOjbCourse = new ArrayList<>();
		
		String result = "Sign up failed";
		for(ImpartGroup impartGroup : impartGroups) {
			String ift = "s";
			if(!courseDetailRepository.existsByImpartgroupAndEnrollment(impartGroup, enrollment)) {
				courseDetail.add(new CourseDetail("new",impartGroup,enrollment, (long) 0));	
				result = "Successful registration";
				ift = null;
			}
			if (ift != null) {
				listaOjbCourse.add(new CourseForm(impartGroup.getImpart().getCourseid().getCoursename()));
				result = "Sign up failed";
			}
		}
		
		try {
			courseDetailRepository.saveAll(courseDetail);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		return  new SmsValidator(result,listaOjbCourse);
	}

	@Override
	public void createEnrollmentStudent(CourseDetailForm courseDetailForm, Student fkstudent) throws SchoolException {
		String anio = UtilsSchool.fecha(true);
		Enrollment enrollment = new Enrollment(
				courseDetailForm.getDni()+anio,
				anio,
				courseDetailForm.getObservations(),
				fkstudent,
				courseDetailForm.getFkdegree());
		
		try {
			enrollmentRepository.save(enrollment);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR");
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
	//	return enrollment;
	}
	

}
