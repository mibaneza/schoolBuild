package com.school.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import com.school.dto.ClassroomDto;


@Entity
@Table(name = "classroom", uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "section" })})
public class Classroom implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long capacity;
	
	@NaturalId
	private String section;
	
	private Long vacancies;
	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkclassroom")
	private List<ImpartGroup> impartGroup;
	
	

	public Classroom(Long capacity, String section, Long vacancies, List<ImpartGroup> impartGroup) {
		this.capacity = capacity;
		this.section = section;
		this.vacancies = vacancies;
		this.impartGroup = impartGroup;
	}
	
	public Classroom(ClassroomDto classroomDto) {
		this.capacity = classroomDto.getCapacity();
		this.section = classroomDto.getSection();
		this.vacancies = classroomDto.getVacancies();
	}

	public Classroom() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Long getVacancies() {
		return vacancies;
	}

	public void setVacancies(Long vacancies) {
		this.vacancies = vacancies;
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
