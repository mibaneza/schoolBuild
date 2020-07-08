package com.school.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "dayweek",uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "name_day_week" })})
public class DayWeek implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name = "name_day_week")
	private String namedayweek;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "day_week", referencedColumnName = "id")
	private List<Horary> horary= new ArrayList<>();
	
	public DayWeek() {}	

	public DayWeek(String namedayweek) {
		this.namedayweek = namedayweek;
	}

	public DayWeek(Long id, String namedayweek, List<Horary> horary) {
		this.id = id;
		this.namedayweek = namedayweek;
		this.horary = horary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamedayweek() {
		return namedayweek;
	}

	public void setNamedayweek(String namedayweek) {
		this.namedayweek = namedayweek;
	}

	public List<Horary> getHorary() {
		return horary;
	}

	public void setHorary(List<Horary> horary) {
		this.horary = horary;
	}
	
}
