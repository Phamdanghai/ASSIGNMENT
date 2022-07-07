package com.nashtech.assignment.pdh.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.nashtech.assignment.pdh.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationDTO {
	private Long infId;

	@NotEmpty(message = "Name must not be empty")
	private String infFullName;

	@NotEmpty(message = "phoneNumber name must not be empty")
	@Pattern(regexp = "^0\\d{9}", message = "Phone Number must have 10 number and start with 0")
	private String infPhone;

	@NotEmpty(message = "Address must not be empty")
	private String infAddress;

	private Users user;
}
