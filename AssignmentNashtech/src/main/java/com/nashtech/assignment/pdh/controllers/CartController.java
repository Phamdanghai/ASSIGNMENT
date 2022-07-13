package com.nashtech.assignment.pdh.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/shoppingCart")
public class CartController {
	@Autowired
	ICartItemService carItemService;

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin') or hasAuthority('Customer')")
	public Collection<CartItemDTO> getCartByIdAccount(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return carItemService.getCartByIdAccount(id);
	}

	@PostMapping("/")
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<?> addCart(@RequestBody CartItemDTO cartItemDto) throws ResourceNotFoundException {
		return carItemService.addCart(cartItemDto);
	}

	@PutMapping("/")
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<?> updateCart(@RequestBody CartItemDTO cartItemDto) throws ResourceNotFoundException {
		return carItemService.updateCart(cartItemDto);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('Customer')")
	public ResponseEntity<?> deleteCart(@PathVariable Long id) throws ResourceNotFoundException {
		return carItemService.deleteCart(id);
	}
}
