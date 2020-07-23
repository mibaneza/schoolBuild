package com.school.service.util.mapper.all;

import java.util.ArrayList;
import java.util.List;

import com.school.dto.AssistanceDto;
import com.school.dto.ClassroomDto;
import com.school.dto.CourseDetaiAllProflDto;
import com.school.dto.HoraryDto;
import com.school.dto.ImpartDto;
import com.school.dto.ImpartGruopDto;
import com.school.dto.ProfessorAllDto;
import com.school.dto.QualificationDto;
import com.school.dto.StudentDto;
import com.school.entity.CourseDetail;
import com.school.entity.Horary;
import com.school.entity.Assistance;
import com.school.entity.Impart;
import com.school.entity.ImpartGroup;
import com.school.entity.Professor;
import com.school.entity.Qualification;
import com.school.service.util.napper.HoraryMapper;
import com.school.service.util.napper.QualificationMapper;


public class ProfessorMapperAll {
	

	public static List<CourseDetaiAllProflDto> courseDetailDtoList(List<CourseDetail> courseDetails) {
		
		List<CourseDetaiAllProflDto> courseDetailDto = new ArrayList<CourseDetaiAllProflDto>();
		for (CourseDetail coursedetail : courseDetails) {
			courseDetailDto.add(new CourseDetaiAllProflDto(
					 new StudentDto(coursedetail.getEnrollment().getFkstudent())
					,QualificationMapper.qualificationsDtoList(coursedetail.getQualification())
					,coursedetail.getAssistance()
					));
			
		}
		return courseDetailDto;
	}
	public static List<ImpartGruopDto> impartGruopDtooList(List<ImpartGroup> impartGroups) {
		List<ImpartGruopDto> impartGruopDto = new ArrayList<>();
		for (ImpartGroup impartGroup : impartGroups) {
			
			
			
			impartGruopDto.add(new ImpartGruopDto(
					new ClassroomDto(impartGroup.getFkclassroom())
					,HoraryMapper.horaryDtoList(impartGroup.getHorary())
					,courseDetailDtoList(impartGroup.getCoursedetail())));
	}
		return impartGruopDto;
	}
	
	
	public static List<ImpartDto> impartDtoList(List<Impart> imparts) {
		List<ImpartDto> impartDto = new ArrayList<>();
		for (Impart impart : imparts) {	
			impartDto.add(new ImpartDto(impart.getCourseid(),impartGruopDtooList(impart.getImparteGrupo())));
		}
		return impartDto;
	}
	
	public static ProfessorAllDto ProfessortDtoConverter(Professor professor) {
		return new ProfessorAllDto(professor.getName(),
				professor.getNum(),
				impartDtoList(professor.getImpart()));
	}
	
}
