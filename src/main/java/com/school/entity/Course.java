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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table
public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String coursename;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_course", referencedColumnName = "id")
	private List<Impart> impart= new ArrayList<>();
	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;

	
	public Course() {}



	public Course(String coursename) {
		this.coursename = coursename;
	}



	public Course(Long id, String coursename, List<Impart> impart, Date finsert,
			Date fupdate) {
		this.id = id;
		this.coursename = coursename;
		this.impart = impart;
		this.finsert = finsert;
		this.fupdate = fupdate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getCoursename() {
		return coursename;
	}



	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}



	public List<Impart> getImpart() {
		return impart;
	}



	public void setImpart(List<Impart> impart) {
		this.impart = impart;
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



	public List<Impart> getImparte() {
		return impart;
	}

	public void setImparte(List<Impart> impart) {
		this.impart = impart;
	}
	
	
	

}
