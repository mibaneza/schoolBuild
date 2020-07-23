package com.school.dto;

import com.school.entity.Horary;

public class HoraryDto {
	
	private String dayweek;
	
	private String starttime;
	
	private String endtime;



	public HoraryDto(String dayweek, String starttime, String endtime) {
		this.dayweek = dayweek;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	public HoraryDto(Horary horary) {
		this.dayweek = horary.getDayweek().getNamedayweek();
		this.starttime = horary.getHours().getStarttime();
		this.endtime = horary.getHours().getEndtime();
	}

	public HoraryDto() {}

	public String getDayweek() {
		return dayweek;
	}

	public void setDayweek(String dayweek) {
		this.dayweek = dayweek;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

}
