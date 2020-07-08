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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "enrollment", uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "registrationnumber" }) })
public class Enrollment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String registrationnumber;
	
	@NotBlank
	@Size(min = 3, max = 4)
	private String date;
	
	@NotBlank
	@Size(min = 3, max = 200)
	private String observations;
	
	private Long studentid;
	
	private Long degreeid;
	
	//@OneToMany(cascade = CascadeType.ALL)
	@OneToOne(mappedBy = "enrollment", cascade = CascadeType.ALL)
	private GroupsEnrollment group ;
	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;

	public Enrollment(String registrationnumber, String date,
			String observations, Long studentid, Long degreeid) {
		this.registrationnumber = registrationnumber;
		this.date = date;
		this.observations = observations;
		this.studentid = studentid;
		this.degreeid = degreeid;
	}

	public Enrollment() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationnumber() {
		return registrationnumber;
	}

	public void setRegistrationnumber(String registrationnumber) {
		this.registrationnumber = registrationnumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Long getStudentid() {
		return studentid;
	}

	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}

	public Long getDegreeid() {
		return degreeid;
	}

	public void setDegreeid(Long degreeid) {
		this.degreeid = degreeid;
	}


	public GroupsEnrollment getGroup() {
		return group;
	}

	public void setGroup(GroupsEnrollment group) {
		this.group = group;
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
