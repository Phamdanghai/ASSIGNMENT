package com.nashtech.assignment.pdh.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nashtech.assignment.pdh.entities.Users;
import com.nashtech.assignment.pdh.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Users users = userRepository.getUserEmail(email)
				.orElseThrow(
						() -> new UsernameNotFoundException("User Not Found with -> username or email : " + email)
				);
		
		return UserDetailsImpl.build(users);
	}

}
