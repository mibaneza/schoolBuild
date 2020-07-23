package com.school.dto;

import java.util.List;

import com.school.entity.ImpartGroup;

public class ImpartGruopDto {
	private ClassroomDto classroom;
	private List<HoraryDto> horary;
	private List<CourseDetaiAllProflDto> coursedetaildto;
	
	public ImpartGruopDto(ClassroomDto classroom, List<HoraryDto> horary, List<CourseDetaiAllProflDto> coursedetaildto) {
		this.classroom = classroom;
		this.horary = horary;
		this.coursedetaildto = coursedetaildto;
	}
/*	public ImpartGruopDto(ImpartGroup impartGroup, List<CourseDetailDto> coursedetaildto) {
		this.classroom = new ClassroomDto(impartGroup.getFkclassroom());
		this.horary = new HoraryDto(impartGroup.getFkhorary());

	}
	*/
	public ImpartGruopDto() {}

	public ClassroomDto getClassroom() {
		return classroom;
	}
	public void setClassroom(ClassroomDto classroom) {
		this.classroom = classroom;
	}

	public List<HoraryDto> getHorary() {
		return horary;
	}
	public void setHorary(List<HoraryDto> horary) {
		this.horary = horary;
	}
	public List<CourseDetaiAllProflDto> getCoursedetaildto() {
		return coursedetaildto;
	}
	public void setCoursedetaildto(List<CourseDetaiAllProflDto> coursedetaildto) {
		this.coursedetaildto = coursedetaildto;
	}
	
	
}
