package com.nashtech.assignment.pdh.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {
	@NotEmpty(message = "Password must not be empty")
	@Size(min = 6, max = 40, message = "The length of the password must be between 6 and 40 characters")
	private String password;

}
