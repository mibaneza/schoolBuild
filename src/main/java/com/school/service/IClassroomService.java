package com.school.service;

import java.util.List;

import com.school.dto.ClassroomDto;
import com.school.exception.SchoolException;

public interface IClassroomService {
	public String createClassroom(ClassroomDto classroomDto) throws SchoolException;
	public List<ClassroomDto> findAllClassroom() throws SchoolException;
	public ClassroomDto findbyClassroom(String section) throws SchoolException;
	public ClassroomDto updateClassroom(ClassroomDto classroomDto) throws SchoolException;
    public String deleteClassroom(String section) throws SchoolException;

}
