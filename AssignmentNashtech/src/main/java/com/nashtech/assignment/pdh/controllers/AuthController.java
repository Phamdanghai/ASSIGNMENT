package com.nashtech.assignment.pdh.controllers;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.entities.Roles;
import com.nashtech.assignment.pdh.entities.Users;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.RoleRepository;
import com.nashtech.assignment.pdh.repositories.UserRepository;
import com.nashtech.assignment.pdh.request.LoginRequest;
import com.nashtech.assignment.pdh.request.SignupRequest;
import com.nashtech.assignment.pdh.response.JwtResponse;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.security.jwt.JwtUtils;
import com.nashtech.assignment.pdh.security.service.UserDetailsImpl;
import com.nashtech.assignment.pdh.services.IAuthService;

@EnableAutoConfiguration
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	IAuthService iAuthService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		return iAuthService.authenticateUser(loginRequest);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest)
			throws ResourceNotFoundException {
		return iAuthService.signup(signUpRequest);
	}

}