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
	
	@NaturalId
	private String registrationnumber;
	
	@NotBlank
	@Size(min = 3, max = 4)
	private String date;
	
	@NotBlank
	@Size(min = 3, max = 200)
	private String observations;


	@ManyToOne
	@JoinColumn(name = "fk_student", nullable = false)
	private Student fkstudent;
	
	@Column(name = "fk_degree")
	private Long fkdegree;
	
	//@OneToMany(cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "enrollment", cascade = CascadeType.ALL)
	private List<CourseDetail> coursedetail = new ArrayList<>();
	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;

	public Enrollment(String registrationnumber, String date,
			String observations, Student fkstudent, Long fkdegree,
			List<CourseDetail> coursedetail) {
		this.registrationnumber = registrationnumber;
		this.date = date;
		this.observations = observations;
		this.fkstudent = fkstudent;
		this.fkdegree = fkdegree;
		this.coursedetail = coursedetail;
	}

	public Enrollment(String registrationnumber,  String date,
			 String observations, Student fkstudent, Long fkdegree) {
		this.registrationnumber = registrationnumber;
		this.date = date;
		this.observations = observations;
		this.fkstudent = fkstudent;
		this.fkdegree = fkdegree;
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

	public Student getFkstudent() {
		return fkstudent;
	}

	public void setFkstudent(Student fkstudent) {
		this.fkstudent = fkstudent;
	}

	public Long getFkdegree() {
		return fkdegree;
	}

	public void setFkdegree(Long fkdegree) {
		this.fkdegree = fkdegree;
	}

	public List<CourseDetail> getCoursedetail() {
		return coursedetail;
	}

	public void setCoursedetail(List<CourseDetail> coursedetail) {
		this.coursedetail = coursedetail;
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
