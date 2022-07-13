package com.nashtech.assignment.pdh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.services.IUserService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	IUserService userService;
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('customer') or hasAuthority('admin')")
	public ResponseEntity<?> getOrders(@PathVariable("id") Long id) throws ResourceNotFoundException{
		return userService.getOrdersbyIdAccount(id);
	}
}
