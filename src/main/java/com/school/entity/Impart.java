package com.school.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Impart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_course", nullable = false)
	private Course courseid;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_professor", nullable = false)
	private Professor professorid;
	
	@OneToMany(cascade = CascadeType.ALL,
	mappedBy = "impart")
	private List<ImpartGroup> imparteGrupo= new ArrayList<>();


	public Impart(Course courseid, Professor professorid) {
		this.courseid = courseid;
		this.professorid = professorid;
	}

	public Impart(Long id, Course courseid, Professor professorid, List<ImpartGroup> imparteGrupo) {
		this.id = id;
		this.courseid = courseid;
		this.professorid = professorid;
		this.imparteGrupo = imparteGrupo;
	}

	public Impart() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourseid() {
		return courseid;
	}


	public void setCourseid(Course courseid) {
		this.courseid = courseid;
	}

	public Professor getProfessorid() {
		return professorid;
	}


	public void setProfessorid(Professor professorid) {
		this.professorid = professorid;
	}


	public List<ImpartGroup> getImparteGrupo() {
		return imparteGrupo;
	}


	public void setImparteGrupo(List<ImpartGroup> imparteGrupo) {
		this.imparteGrupo = imparteGrupo;
	}


}
