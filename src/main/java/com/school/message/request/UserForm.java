package com.school.message.request;

import java.util.Date;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserForm {

    @Size(min = 3, max = 50)
    private String name;


    @Size(min = 6, max = 40)
    private String password;
    

	@Size(min = 3, max = 50)
	private String lastname;
    

	@Size(min = 3, max = 50)
	private String motherslastname;
	

	@Temporal(TemporalType.DATE)
	private Date datebirth;
	
	private Long tutordegree;
	
	private String reference;
	
	private String attorney;

	private Long dni;
	
	private Boolean sex;

	private Boolean est;
    

	
    private Set<RoleForm> role;

    
    public Long getTutordegree() {
		return tutordegree;
	}

	public void setTutordegree(Long tutordegree) {
		this.tutordegree = tutordegree;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAttorney() {
		return attorney;
	}

	public void setAttorney(String attorney) {
		this.attorney = attorney;
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

	public Set<RoleForm> getRole() {
		return role;
	}

	public void setRole(Set<RoleForm> role) {
		this.role = role;
	}
 

	

	
}