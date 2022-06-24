package com.nashtech.assignment.pdh.controllers;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import javax.validation.Valid;

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
import com.nashtech.assignment.pdh.repositories.RoleRepository;
import com.nashtech.assignment.pdh.repositories.UserRepository;
import com.nashtech.assignment.pdh.request.LoginRequest;
import com.nashtech.assignment.pdh.request.SignupRequest;
import com.nashtech.assignment.pdh.response.JwtResponse;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.security.jwt.JwtUtils;
import com.nashtech.assignment.pdh.security.service.UserDetailsImpl;

@EnableAutoConfiguration
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	final private AuthenticationManager authenticationManager;

	final private UserRepository userRepository;

	final private RoleRepository roleRepository;

	final private PasswordEncoder encoder;

	final private JwtUtils jwtUtils;

	public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
			RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
		this.jwtUtils = jwtUtils;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

		// if go there, the user/password is correct
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// generate jwt to return to client
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(), roles.get(0)));

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		Optional<Users> optionalAcc = userRepository.getUserEmail(signUpRequest.getEmail());
		if (optionalAcc.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
		}

//         Create new user's account
		Users account = new Users(signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

		String strRoles = signUpRequest.getRole();

		Optional<Roles> optionalRole = roleRepository.findById(Long.parseLong(strRoles));
		if (optionalRole.isPresent()) {
			Roles roles = optionalRole.get();
			account.setRoles(roles);

			userRepository.save(account);
			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		}
		new MessageResponse("Error: Email is already taken!");
		return null;
	}
}