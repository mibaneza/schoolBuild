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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "group_enrollment")
public class GroupsEnrollment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@OneToOne
	@JoinColumn(name = "fk_enrollment", updatable = false, nullable = false)
	private Enrollment enrollment;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "groupids", referencedColumnName = "id")
	private List<Assistance> assistance = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "groupid", referencedColumnName = "id")
	private List<CourseDetail> detallecurso= new ArrayList<>();
	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;
	
	

	public GroupsEnrollment() {	}


	public GroupsEnrollment(Long id, String description, Enrollment enrollment, List<Assistance> assistance,
			List<CourseDetail> detallecurso) {
		this.id = id;
		this.description = description;
		this.enrollment = enrollment;
		this.assistance = assistance;
		this.detallecurso = detallecurso;
	}


	public GroupsEnrollment(Long id, String description, Enrollment enrollment, List<Assistance> assistance,
			List<CourseDetail> detallecurso, Date finsert, Date fupdate) {
		this.id = id;
		this.description = description;
		this.enrollment = enrollment;
		this.assistance = assistance;
		this.detallecurso = detallecurso;
		this.finsert = finsert;
		this.fupdate = fupdate;
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


	public List<Assistance> getAssistance() {
		return assistance;
	}

	public void setAssistance(List<Assistance> assistance) {
		this.assistance = assistance;
	}

	public List<CourseDetail> getDetallecurso() {
		return detallecurso;
	}

	public void setDetallecurso(List<CourseDetail> detallecurso) {
		this.detallecurso = detallecurso;
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
