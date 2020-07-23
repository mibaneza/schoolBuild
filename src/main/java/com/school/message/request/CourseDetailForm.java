package com.school.message.request;

public class CourseDetailForm {
	private String date;
	private Long dni;
	private String observations;
	private Long fkdegree;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public Long getFkdegree() {
		return fkdegree;
	}
	public void setFkdegree(Long fkdegree) {
		this.fkdegree = fkdegree;
	}

}
