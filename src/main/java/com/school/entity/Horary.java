package com.school.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "horary")
public class Horary implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "fk_day_week", nullable = false)
	private DayWeek dayweek;
	
	@ManyToOne
    @JoinColumn(name = "fk_hour", nullable = false)
	private Hour hours;

	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;
	
	public Horary(Long id, DayWeek dayweek, Hour hours) {
		this.id = id;
		this.dayweek = dayweek;
		this.hours = hours;
	}
	public Horary(DayWeek dayweek, Hour hours) {
		this.dayweek = dayweek;
		this.hours = hours;
	}
	public Horary() {}

	public DayWeek getDayweek() {
		return dayweek;
	}

	public void setDayweek(DayWeek dayweek) {
		this.dayweek = dayweek;
	}

	public Hour getHours() {
		return hours;
	}

	public void setHours(Hour hours) {
		this.hours = hours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFinsert() {
		return finsert;
	}

	public void setFinsert(Date finsert) {
		this.finsert = finsert;
	}

	public Date getFupdate() {
		return fupdate;
	}

	public void setFupdate(Date fupdate) {
		this.fupdate = fupdate;
	}


}
