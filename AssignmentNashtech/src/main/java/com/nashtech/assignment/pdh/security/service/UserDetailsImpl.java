package com.nashtech.assignment.pdh.security.service;

import java.util.Collection;
import java.util.Collections;

import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nashtech.assignment.pdh.entities.Users;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id,String email,String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Users users) {
//		List<GrantedAuthority> authorities = users.getRoles().stream()
//	            .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//	            .collect(Collectors.toList());

		Collection<? extends GrantedAuthority> authorities = Collections
				.singleton(new SimpleGrantedAuthority(users.getRoles().getRoleName()));

		return new UserDetailsImpl(users.getUserId(),users.getUserEmail(), users.getUserPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
	

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return username;
//	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

}
