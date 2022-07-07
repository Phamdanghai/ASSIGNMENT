package com.nashtech.assignment.pdh.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.dto.UserUpdateDTO;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.services.IUserService;

@RestController
@RequestMapping("/account")
public class UserController {

	@Autowired
	IUserService iUserService;

	@PutMapping("/{id}")
	public ResponseEntity<?> updatePassword(@PathVariable("id") Long id,
			@Valid @RequestBody UserUpdateDTO userUpdateDTO) throws ResourceNotFoundException {
		return iUserService.updateAccount(id, userUpdateDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable Long id) throws ResourceNotFoundException {
		return iUserService.deleteAccount(id);
	}
}
