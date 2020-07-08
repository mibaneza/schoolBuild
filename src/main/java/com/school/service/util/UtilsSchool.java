package com.school.service.util;

import java.util.Calendar;
import java.util.List;

public class UtilsSchool {
	public static String fecha(Boolean fechax) {
		Calendar fecha = Calendar.getInstance();
		if (fechax = true) {
			String anio = Integer.toString(fecha.get(Calendar.YEAR));
			return anio;
		}
		String[] strDays = new String[] { "Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
		return strDays[fecha.get(Calendar.DAY_OF_WEEK) - 1];
	}

	public static boolean chkEmpty(final List<Object> obj) {
		return obj == null || obj.isEmpty();
	}

}
