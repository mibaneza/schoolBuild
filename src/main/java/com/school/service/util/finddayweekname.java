package com.school.service.util;

import com.school.entity.DayWeek;

public class finddayweekname {
	public static DayWeek dayweek(Long id) {
		DayWeek dayWeek = null;
		
	   switch (id.intValue()) {
	case 1:
		Long lu = (long) 1;
		dayWeek = new DayWeek(lu,"Lunes");
		break;
	case 2:
		Long ma = (long) 2;
		dayWeek = new DayWeek(ma,"Martes");
		break;
	case 3:
		Long mi = (long) 3;
		dayWeek = new DayWeek(mi,"Miercoles");
		break;
	case 4:
		Long ju = (long) 4;
		dayWeek = new DayWeek(ju,"Jueves");
		break;
	case 5:
		Long vi = (long) 5;
		dayWeek = new DayWeek(vi,"Viernes");
		break;
	case 6:
		Long sa = (long) 6;
		dayWeek = new DayWeek(sa,"Sabado");
		break;
	default:
		Long dso = (long) 7;
		dayWeek = new DayWeek(dso,"Domingo");
		break;
	}
		return dayWeek;
	}
}
