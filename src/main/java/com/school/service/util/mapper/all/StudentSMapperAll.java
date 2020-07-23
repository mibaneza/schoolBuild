package com.school.service.util.mapper.all;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.ClassroomDto;
import com.school.dto.StudentDto;
import com.school.dto.Student.CourseDetailDto;
import com.school.dto.Student.EnrollmentAllDto;
import com.school.dto.Student.ImpartGroupDto;
import com.school.dto.Student.StudentsOneAll;
import com.school.entity.CourseDetail;
import com.school.entity.Degree;
import com.school.entity.Enrollment;
import com.school.entity.ImpartGroup;
import com.school.entity.Student;
import com.school.exception.NotFountException;
import com.school.repository.IDegreeRepository;
import com.school.service.util.napper.AssistanceMapper;
import com.school.service.util.napper.HoraryMapper;
import com.school.service.util.napper.QualificationMapper;


public class StudentSMapperAll {	


	public static ImpartGroupDto ImpartGroupDtoAllLists(ImpartGroup impartGroups) {	
		return new ImpartGroupDto(impartGroups.getImpart().getProfessorid().getName(),
				impartGroups.getImpart().getCourseid().getCoursename(),
				new ClassroomDto(impartGroups.getFkclassroom()),
				HoraryMapper.horaryDtoList(impartGroups.getHorary()));
	}
	
	public static List<CourseDetailDto> coursedetailDtoAllList(List<CourseDetail> courseDetails) {	
		List<CourseDetailDto> courseDetailDto = new ArrayList<CourseDetailDto>();
		for (CourseDetail courseDetail : courseDetails) {
			courseDetailDto.add(new CourseDetailDto(courseDetail,
					ImpartGroupDtoAllLists(courseDetail.getImpartgroup()),
					AssistanceMapper.assistanceDtoList(courseDetail.getAssistance()),
					QualificationMapper.qualificationsDtoList(courseDetail.getQualification())));
		}
		return courseDetailDto;
	}
	/*
	public  List<EnrollmentAllDto> enrollmentAllDtoList(List<Enrollment> enrollments) {	
		List<EnrollmentAllDto> enrollmentAllDto = new ArrayList<EnrollmentAllDto>();
		for (Enrollment enrollment : enrollments) {

			//enrollmentAllDto.add(new EnrollmentAllDto(enrollment,coursedetailDtoAllList(enrollment.getCoursedetail())));
		}
		return enrollmentAllDto;
	}
	
	public static StudentsOneAll studentOneAll(Student student, List<Enrollment> enrollments){
		StudentDto studentDto = new StudentDto(student);

		return new StudentsOneAll(studentDto,enrollmentAllDtoList(enrollments));
	}*/
}
