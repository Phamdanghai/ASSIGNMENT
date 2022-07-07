package com.nashtech.assignment.pdh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.services.IUserService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	IUserService userService;
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrders(@PathVariable("id") Long id) throws ResourceNotFoundException{
		return userService.getOrdersbyIdAccount(id);
	}
}
