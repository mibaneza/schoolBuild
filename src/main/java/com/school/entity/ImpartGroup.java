package com.school.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ImpartGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long impartid;
	
	private Long aulaid;
	
	private Long horaryid;

	public ImpartGroup() {}

	public ImpartGroup(Long id, Long impartid, Long aulaid, Long horaryid) {
		this.id = id;
		this.impartid = impartid;
		this.aulaid = aulaid;
		this.horaryid = horaryid;
	}

	public Long getHoraryid() {
		return horaryid;
	}

	public void setHoraryid(Long horaryid) {
		this.horaryid = horaryid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getImpartid() {
		return impartid;
	}

	public void setImpartid(Long impartid) {
		this.impartid = impartid;
	}

	public Long getAulaid() {
		return aulaid;
	}

	public void setAulaid(Long aulaid) {
		this.aulaid = aulaid;
	}

}
