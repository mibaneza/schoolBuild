package com.school.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.entity.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

    private String name;

    private String username;

    private String lastname;
    
    private String motherslastname;
    
    private Date datebirth;
    
	private Long dni;

	private Boolean sex;

	private Boolean est;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
    
    public UserPrinciple(Long id, String name, String username, 
    		String lastname, String motherslastname, Date datebirth,
			Long dni, Boolean sex, Boolean est, String password,
			Collection<? extends GrantedAuthority> authorities) {

		this.id = id;
		this.name = name;
		this.username = username;
		this.lastname = lastname;
		this.motherslastname = motherslastname;
		this.datebirth = datebirth;
		this.dni = dni;
		this.sex = sex;
		this.est = est;
		this.password = password;
		this.authorities = authorities;
	}


    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getLastname(),
                user.getMotherslastname(),
                user.getDatebirth(),
                user.getDni(),
                user.getSex(),
                user.getEst(),
                user.getPassword(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
		return lastname;
	}

	public String getMotherslastname() {
		return motherslastname;
	}

	public Date getDatebirth() {
		return datebirth;
	}

	public Long getDni() {
		return dni;
	}

	public Boolean getSex() {
		return sex;
	}

	public Boolean getEst() {
		return est;
	}

	@Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}