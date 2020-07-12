package com.school.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.school.entity.Role;
import com.school.entity.User;
import com.school.message.response.JwtResponse;

public class UserDto {
	private String username;	
	private String name;
	private String lastname;
	private String motherslastname;
	private Date datebirth;
	private Long dni;
	private Boolean sex;

	private Set<RoleDto> rolesDto = new HashSet<>();
	
	
	

	
	public UserDto(String username, String name, String lastname, String motherslastname, Date datebirth, Long dni,
			Boolean sex, Set<RoleDto> rolesDto) {
	
		this.username = username;
		this.name = name;
		this.lastname = lastname;
		this.motherslastname = motherslastname;
		this.datebirth = datebirth;
		this.dni = dni;
		this.sex = sex;
		this.rolesDto = rolesDto;
	}



	public UserDto() {	// TODO Auto-generated constructor stub
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


	public Set<RoleDto> getRolesDto() {
		return rolesDto;
	}

	public void setRolesDto(Set<RoleDto> rolesDto) {
		this.rolesDto = rolesDto;
	}
	

}
