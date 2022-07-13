package com.nashtech.assignment.pdh.services.impl;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.nashtech.assignment.pdh.entities.Information;
import com.nashtech.assignment.pdh.entities.Roles;
import com.nashtech.assignment.pdh.entities.Users;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.InformationRepository;
import com.nashtech.assignment.pdh.repositories.RoleRepository;
import com.nashtech.assignment.pdh.repositories.UserRepository;
import com.nashtech.assignment.pdh.request.LoginRequest;
import com.nashtech.assignment.pdh.request.SignupRequest;
import com.nashtech.assignment.pdh.response.JwtResponse;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.security.jwt.JwtAuthTokenFilter;
import com.nashtech.assignment.pdh.security.jwt.JwtUtils;
import com.nashtech.assignment.pdh.security.service.UserDetailsImpl;
import com.nashtech.assignment.pdh.services.IAuthService;

@Component
public class AuthServiceImpl implements IAuthService {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private InformationRepository informationRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
			RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
		this.jwtUtils = jwtUtils;
	}

	@Override
	public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		// if go there, the user/password is correct
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// generate jwt to return to client
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(), roles.get(0)));

	}

	@Override
	public ResponseEntity<?> signup(SignupRequest signUpRequest) throws ResourceNotFoundException {
		Optional<Users> optionalAcc = userRepository.getUserEmail(signUpRequest.getEmail());
		if (optionalAcc.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
		}

//         Create new user's account
		Users users = new Users(signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

		String strRoles = signUpRequest.getRole();

		Optional<Roles> optionalRole = roleRepository.findById(Long.parseLong(strRoles));
		if (optionalRole.isPresent()) {
			Roles roles = optionalRole.get();
			users.setRoles(roles);

			userRepository.save(users);

			Information information = modelMapper.map(signUpRequest, Information.class);
			information.setUsers(users);
			informationRepository.save(information);
			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		}

		throw new ResourceNotFoundException("Role not found");
	}

}
