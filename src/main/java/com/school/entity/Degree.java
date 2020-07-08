package com.school.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Degree implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	private String name;
	
	private Long levelid;

	public Long getId() {
		return id;
	}
	
	public Degree() {}

	public Degree(Long id, String name, Long levelid) {
		this.id = id;
		this.name = name;
		this.levelid = levelid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLevelid() {
		return levelid;
	}

	public void setLevelid(Long levelid) {
		this.levelid = levelid;
	}

}
