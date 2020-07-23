package com.school.service.util.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.school.dto.ClassroomDto;
import com.school.entity.Classroom;

@Component("classroommapper")
public class ClassroomMapper {
	public static List<ClassroomDto> convertirClassroomDtoList(List<Classroom> classrooms) {
		List<ClassroomDto> classroomDto = new ArrayList<>();
		for (Classroom classroom : classrooms) {
			classroomDto.add(new ClassroomDto(classroom));
		}
		return classroomDto;
	}
}
