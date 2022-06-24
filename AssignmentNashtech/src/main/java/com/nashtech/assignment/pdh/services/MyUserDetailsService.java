package com.nashtech.assignment.pdh.services;

import org.apache.tomcat.jni.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nashtech.assignment.pdh.entities.Users;

public class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return new org.springframework.security.core.userdetails.User("foo", "foo", null);
	}

}
