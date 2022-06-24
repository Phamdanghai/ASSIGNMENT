package com.nashtech.assignment.pdh.request;

import javax.validation.constraints.*;

public class SignupRequest {
//	@NotBlank
//	@Size(min = 3, max = 20)
//	private String userName;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	private String role;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}