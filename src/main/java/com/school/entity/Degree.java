package com.school.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
	
    @Column(name = "fk_level")
	private Long fklevel;

	public Long getId() {
		return id;
	}
	
	
	
	public Degree(Long id, String name, Long fklevel) {
		this.id = id;
		this.name = name;
		this.fklevel = fklevel;
	}



	public Degree() {}


	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFklevel() {
		return fklevel;
	}

	public void setFklevel(Long fklevel) {
		this.fklevel = fklevel;
	}

}
