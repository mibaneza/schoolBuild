package com.school.dto;


import com.school.entity.Role;
import com.school.entity.RoleName;

public class RoleDto {

    private RoleName name;

    public RoleDto() {}

    public RoleDto(RoleName name) {
        this.name = name;
    }



    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

}