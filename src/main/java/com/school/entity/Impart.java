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


@Entity
@Table
public class Impart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fk_course")
	private Long courseid;
	
	@Column(name = "fk_professor")
	private Long professorid;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "impartid", referencedColumnName = "id")
	private List<CourseDetail> detallecurso= new ArrayList<>();
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "impartid", referencedColumnName = "id")
	private List<ImpartGroup> imparteGrupo= new ArrayList<>();


}
