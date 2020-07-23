package com.school.dto;

import java.util.Date;

import com.school.entity.Qualification;

public class QualificationDto {
	private Long id;
	private String description;
	private Double quantity;
	private Date finsert;
	
	public QualificationDto(Long id, String description, Double quantity, Date finsert) {
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.finsert = finsert;
	}
	
	public QualificationDto(Qualification qualification) {
		this.id = qualification.getId();
		this.description = qualification.getDescription();
		this.quantity = qualification.getQuantity();
		this.finsert = qualification.getFinsert();
	}

	public QualificationDto() {	}
	
	public Date getFinsert() {
		return finsert;
	}

	public void setFinsert(Date finsert) {
		this.finsert = finsert;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	
}
