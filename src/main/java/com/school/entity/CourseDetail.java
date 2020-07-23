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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table
public class CourseDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "fk_impart_group", nullable = false)
	private ImpartGroup impartgroup;
	
	@ManyToOne
	@JoinColumn(name = "fk_enrollment", updatable = false, nullable = false)
	private Enrollment enrollment;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_course_detail", referencedColumnName = "id")
	private List<Assistance> assistance = new ArrayList<>();
	
	private Long average;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_course_detail", referencedColumnName = "id")
	private List<Qualification> qualification = new ArrayList<>();

	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;
	


	public CourseDetail(String description, ImpartGroup impartgroup, Enrollment enrollment, List<Assistance> assistance,
			Long average, List<Qualification> qualification) {
		this.description = description;
		this.impartgroup = impartgroup;
		this.enrollment = enrollment;
		this.assistance = assistance;
		this.average = average;
		this.qualification = qualification;
	}



	public CourseDetail(String description, ImpartGroup impartgroup, Enrollment enrollment, Long average) {
		this.description = description;
		this.impartgroup = impartgroup;
		this.enrollment = enrollment;
		this.average = average;
	}



	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public List<Assistance> getAssistance() {
		return assistance;
	}

	public void setAssistance(List<Assistance> assistance) {
		this.assistance = assistance;
	}

	public CourseDetail() {}

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

	public ImpartGroup getImpartgroup() {
		return impartgroup;
	}

	public void setImpartgroup(ImpartGroup impartgroup) {
		this.impartgroup = impartgroup;
	}

	public Long getAverage() {
		return average;
	}

	public void setAverage(Long average) {
		this.average = average;
	}

	public List<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(List<Qualification> qualification) {
		this.qualification = qualification;
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
