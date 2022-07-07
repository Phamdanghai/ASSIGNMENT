package com.nashtech.assignment.pdh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.dto.CartItemDTO;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.services.ICartItemService;

@RestController
@RequestMapping("/shoppingCart")
public class CartController {
	@Autowired
	ICartItemService carItemService;

	@GetMapping("/{id}")
	public ResponseEntity<?> getCartByIdAccount(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return carItemService.getCartByIdAccount(id);
	}

	@PostMapping("/")
	public ResponseEntity<?> addCart(@RequestBody CartItemDTO cartItemDto) throws ResourceNotFoundException {
		return carItemService.addCart(cartItemDto);
	}

	@PutMapping("/")
	public ResponseEntity<?> updateCart(@RequestBody CartItemDTO cartItemDto) throws ResourceNotFoundException {
		return carItemService.updateCart(cartItemDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable Long id) throws ResourceNotFoundException {
		return carItemService.deleteCart(id);
	}
}
