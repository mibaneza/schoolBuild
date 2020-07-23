package com.school.service.util.napper;

import java.util.ArrayList;
import java.util.List;

import com.school.dto.AssistanceDto;
import com.school.entity.Assistance;

public class AssistanceMapper {
	
	public static List<AssistanceDto> assistanceDtoList(List<Assistance> assistances) {	
		List<AssistanceDto> assistanceDtos = new ArrayList<AssistanceDto>();
		for (Assistance assistance : assistances) {
			assistanceDtos.add(new AssistanceDto(assistance));
		}
		return assistanceDtos;
	}
}
