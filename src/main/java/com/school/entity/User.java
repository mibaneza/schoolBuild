package com.school.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "users", uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "username" }),
		@UniqueConstraint(columnNames = { "dni" }) })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String name;

	@NotBlank
	@Size(min = 3, max = 12)
	private String username;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@NotBlank
	@Size(min = 3, max = 50)
	private String lastname;

	@NotBlank
	@Size(min = 3, max = 50)
	private String motherslastname;

	@Temporal(TemporalType.DATE)
	private Date datebirth;

	@NaturalId
	private Long dni;

	private Boolean sex;

	private Boolean est;

	@Column(name = "fecha_insert")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date finsert;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "fecha_update")
	private Date fupdate;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User(){}

	/*
	 * public User(String name, String username, String email, String password) {
	 * this.name = name; this.username = username; this.email = email; this.password
	 * = password; }
	 */
	public User(String username, String password, String name,
			String lastname, String motherslastname, Date datebirth,
			Long dni, Boolean sex, Boolean est) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.motherslastname = motherslastname;
		this.datebirth = datebirth;
		this.dni = dni;
		this.sex = sex;
		this.est = est;
	}

	public User(Long id, String username, String password, String name,
			String lastname, String motherslastname, Date datebirth,
			Long dni, Boolean sex, Boolean est, Date finsert, Date fupdate,
			Set<Role> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.motherslastname = motherslastname;
		this.datebirth = datebirth;
		this.dni = dni;
		this.sex = sex;
		this.est = est;
		this.finsert = finsert;
		this.fupdate = fupdate;
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMotherslastname() {
		return motherslastname;
	}

	public void setMotherslastname(String motherslastname) {
		this.motherslastname = motherslastname;
	}

	public Date getDatebirth() {
		return datebirth;
	}

	public void setDatebirth(Date datebirth) {
		this.datebirth = datebirth;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Boolean getEst() {
		return est;
	}

	public void setEst(Boolean est) {
		this.est = est;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}