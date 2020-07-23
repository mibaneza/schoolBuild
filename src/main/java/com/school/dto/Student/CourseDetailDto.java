package com.school.dto.Student;

import java.util.ArrayList;
import java.util.List;

import com.school.dto.AssistanceDto;
import com.school.dto.QualificationDto;
import com.school.entity.CourseDetail;;

public class CourseDetailDto {
	
	private String description;
	
	private ImpartGroupDto impartgroupdto;
	
	private Long average;
	
	private List<AssistanceDto> assistance = new ArrayList<>();	
	
	private List<QualificationDto> qualification = new ArrayList<>();
	
	public CourseDetailDto(String description, ImpartGroupDto impartgroupdto, Long average,
			List<AssistanceDto> assistance, List<QualificationDto> qualification) {
		this.description = description;
		this.impartgroupdto = impartgroupdto;
		this.average = average;
		this.assistance = assistance;
		this.qualification = qualification;
	}

	public CourseDetailDto(CourseDetail courseDetails,ImpartGroupDto impartGroupDto,
			List<AssistanceDto> assistance, List<QualificationDto> qualification ) {
		this.description = courseDetails.getDescription();
		this.impartgroupdto = impartGroupDto;
		this.average = courseDetails.getAverage();
		this.assistance = assistance;
		this.qualification = qualification;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ImpartGroupDto getImpartgroupdto() {
		return impartgroupdto;
	}

	public void setImpartgroupdto(ImpartGroupDto impartgroupdto) {
		this.impartgroupdto = impartgroupdto;
	}

	public Long getAverage() {
		return average;
	}

	public void setAverage(Long average) {
		this.average = average;
	}

	public List<AssistanceDto> getAssistance() {
		return assistance;
	}

	public void setAssistance(List<AssistanceDto> assistance) {
		this.assistance = assistance;
	}

	public List<QualificationDto> getQualification() {
		return qualification;
	}

	public void setQualification(List<QualificationDto> qualification) {
		this.qualification = qualification;
	}

		
	
}
