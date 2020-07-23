package com.school.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class ImpartGroup implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fk_degree")
	private Long fkdegree;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_classroom", nullable = false)
	private Classroom fkclassroom;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_impart", nullable = false)
	private Impart impart;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "impart_group_horary", 
	joinColumns = @JoinColumn(name = "impartgroup_id"), 
	inverseJoinColumns = @JoinColumn(name = "horary_id"))
	private List<Horary> horary = new ArrayList<>();
	
	//@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "fk_impart_group", referencedColumnName = "id")
	
	@OneToMany(cascade = CascadeType.ALL,
	mappedBy = "impartgroup")
	private List<CourseDetail> coursedetail= new ArrayList<>();
	



	public ImpartGroup(Long fkdegree, Classroom fkclassroom, Impart impart, List<Horary> horary) {
		this.fkdegree = fkdegree;
		this.fkclassroom = fkclassroom;
		this.impart = impart;
		this.horary = horary;
	}

	public ImpartGroup(Long id, Classroom fkclassroom, Impart impart, List<Horary> horary,
			List<CourseDetail> coursedetail) {

		this.id = id;
		this.fkclassroom = fkclassroom;
		this.impart = impart;
		this.horary = horary;
		this.coursedetail = coursedetail;
	}

	public ImpartGroup() {}

	public List<Horary> getHorary() {
		return horary;
	}

	public Long getFkdegree() {
		return fkdegree;
	}

	public void setFkdegree(Long fkdegree) {
		this.fkdegree = fkdegree;
	}

	public void setHorary(List<Horary> horary) {
		this.horary = horary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Impart getImpart() {
		return impart;
	}

	public void setImpart(Impart impart) {
		this.impart = impart;
	}

	public List<CourseDetail> getCoursedetail() {
		return coursedetail;
	}

	public void setCoursedetail(List<CourseDetail> coursedetail) {
		this.coursedetail = coursedetail;
	}

	public Classroom getFkclassroom() {
		return fkclassroom;
	}

	public void setFkclassroom(Classroom fkclassroom) {
		this.fkclassroom = fkclassroom;
	}

}
