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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "professor", uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "num" }) })
public class Professor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@NaturalId
	@Column(name = "num", nullable = false)
	private Long num;
	
	private Long tutordegree;

	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "professorid")
	private List<Impart> impart= new ArrayList<>();
	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;
	
	public Professor() {}
	
	


	public Professor(String name, Long num, Long tutordegree) {
		this.name = name;
		this.num = num;
		this.tutordegree = tutordegree;
	
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getTutordegree() {
		return tutordegree;
	}

	public void setTutordegree(Long tutordegree) {
		this.tutordegree = tutordegree;
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
	
	
	



}
