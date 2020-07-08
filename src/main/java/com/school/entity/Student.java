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
public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String attorney;
	
	@Column(unique = true)
	private Long dni;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String reference;
	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "studentid", referencedColumnName = "id")
	private List<Enrollment> matricula = new ArrayList<>();
	
	public Student(Long id,  String attorney, Long dni,
			String reference) {
	
		this.id = id;
		this.attorney = attorney;
		this.dni = dni;
		this.reference = reference;
	}

	public Student(){}

	public Student(Long id, String attorney, Long dni,
			String reference, Date finsert, Date fupdate) {
		this.id = id;
		this.attorney = attorney;
		this.dni = dni;
		this.reference = reference;
		this.finsert = finsert;
		this.fupdate = fupdate;

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttorney() {
		return attorney;
	}

	public void setAttorney(String attorney) {
		this.attorney = attorney;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public List<Enrollment> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Enrollment> matricula) {
		this.matricula = matricula;
	}
}
