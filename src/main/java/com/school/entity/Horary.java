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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table
public class Horary implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "day_week")
	private Long dayweek;
	
	@Column(name = "end_time")
	private String endtime;
	
	@Column(name = "start_time")
	private String starttime;
	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "horaryid", referencedColumnName = "id")
	private List<ImpartGroup> impartGroup= new ArrayList<>();
	
	public Horary() {}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
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

	public List<ImpartGroup> getImpartGroup() {
		return impartGroup;
	}

	public void setImpartGroup(List<ImpartGroup> impartGroup) {
		this.impartGroup = impartGroup;
	}
	
	
	
}
