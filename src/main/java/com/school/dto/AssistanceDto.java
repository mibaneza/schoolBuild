package com.school.dto;

import java.util.Date;

import com.school.entity.Assistance;

public class AssistanceDto {
	
	private Long lack;
	
	private Long assistance;
	
	private Long delay;
	
	private Date finsert;


	public AssistanceDto(Long lack, Long assistance, Long delay, Date finsert) {
		this.lack = lack;
		this.assistance = assistance;
		this.delay = delay;
		this.finsert = finsert;
	}

	public AssistanceDto(Assistance assistence) {
		this.lack = assistence.getLack();
		this.assistance = assistence.getAssistance();
		this.delay = assistence.getDelay();
		this.finsert = assistence.getFinsert();
	}

	public AssistanceDto() {}

	public Long getLack() {
		return lack;
	}

	public void setLack(Long lack) {
		this.lack = lack;
	}

	public Long getAssistance() {
		return assistance;
	}

	public void setAssistance(Long assistance) {
		this.assistance = assistance;
	}

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}

	public Date getFinsert() {
		return finsert;
	}

	public void setFinsert(Date finsert) {
		this.finsert = finsert;
	}
	
}
