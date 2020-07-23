package com.school.service.util.napper;

import java.util.ArrayList;
import java.util.List;

import com.school.dto.HoraryDto;
import com.school.entity.Horary;

public class HoraryMapper {
	public static List<HoraryDto> horaryDtoList(List<Horary> horarys) {	
		List<HoraryDto> horaryDtos = new ArrayList<HoraryDto>();
		for (Horary horary : horarys) {
			horaryDtos.add(new HoraryDto(horary));
		}
		return horaryDtos;
	}
}
