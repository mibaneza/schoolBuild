package com.school.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
public class Assistance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long lack;
	
	private Long assistance;
	
	private Long delay;
	
	@Column(name = "fk_course_detail")
	private Long fkcoursedetail;

	
	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;

	public Assistance(Long id, Long lack, Long assistance, Long delay, Long fkcoursedetail, Date finsert,
			Date fupdate) {
		this.id = id;
		this.lack = lack;
		this.assistance = assistance;
		this.delay = delay;
		this.fkcoursedetail = fkcoursedetail;
		this.finsert = finsert;
		this.fupdate = fupdate;
	}


	public Assistance() {}
  

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLack() {
		return lack;
	}

	public void setLack(Long lack) {
		this.lack = lack;
	}

	public Long getAssistance() {
		return assistance;
	}

	public void setAssistance(Long assistance) {
		this.assistance = assistance;
	}

	public Long getDelay() {
		return delay;
	}

	public void setDelay(Long delay) {
		this.delay = delay;
	}

	public Long getFkcoursedetail() {
		return fkcoursedetail;
	}

	public void setFkcoursedetail(Long fkcoursedetail) {
		this.fkcoursedetail = fkcoursedetail;
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
