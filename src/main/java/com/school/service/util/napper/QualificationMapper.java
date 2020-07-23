package com.school.service.util.napper;

import java.util.ArrayList;
import java.util.List;

import com.school.dto.QualificationDto;
import com.school.entity.Qualification;

public class QualificationMapper {

	public static List<QualificationDto> qualificationsDtoList(List<Qualification> qualifications) {	
		List<QualificationDto> qualificationsDtos = new ArrayList<QualificationDto>();
		for (Qualification qualification : qualifications) {
			qualificationsDtos.add(new QualificationDto(qualification));
		}
		return qualificationsDtos;
	}
	
}
