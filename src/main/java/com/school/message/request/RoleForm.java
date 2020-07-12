package com.school.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RoleForm {

    @NotBlank
    @Size(min = 3, max = 50)
    private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


    

}
