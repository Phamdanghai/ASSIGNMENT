package com.nashtech.assignment.pdh.services;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.CartItemDTO;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;

@Service
public interface ICartItemService {

	public Collection<CartItemDTO> getCartByIdAccount(Long userId) throws ResourceNotFoundException;

	public ResponseEntity<?> addCart(CartItemDTO cartItemDTO) throws ResourceNotFoundException;

	public ResponseEntity<?> updateCart(CartItemDTO cartItemDTO) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteCart(Long userId) throws ResourceNotFoundException;
}
