package com.nashtech.assignment.pdh.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.nashtech.assignment.pdh.dto.CartItemDTO;
import com.nashtech.assignment.pdh.entities.CartItem;
import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.entities.Users;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.CartRepository;
import com.nashtech.assignment.pdh.repositories.ProductRepository;
import com.nashtech.assignment.pdh.repositories.UserRepository;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.services.ICartItemService;
import com.nashtech.assignment.pdh.services.IProductService;

@Component
public class CartItemServiceImpl implements ICartItemService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	IProductService iProductService;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public Collection<CartItemDTO> getCartByIdAccount(Long userId) throws ResourceNotFoundException {
		Optional<Users> optionalAccount = userRepository.findById(userId);
		if (!optionalAccount.isPresent()) {
			throw new ResourceNotFoundException("Account not found");
		}
		List<CartItem> list = userRepository.findCartByIdAccount(userId);
		List<CartItemDTO> dto = new ArrayList<CartItemDTO>();
		list.forEach(c -> dto.add(modelMapper.map(c, CartItemDTO.class)));
		return dto;
	}

	@Override
	public ResponseEntity<?> addCart(CartItemDTO cartItemDTO) throws ResourceNotFoundException {
		Optional<Products> optionalProduct = productRepository.findById(cartItemDTO.getProducts().getProId());
		if (!optionalProduct.isPresent()) {
			throw new ResourceNotFoundException("Product not found");
		}
		Optional<Users> optionalAccount = userRepository.findById(cartItemDTO.getUsers().getUserId());
		if (!optionalAccount.isPresent()) {
			throw new ResourceNotFoundException("Account not found");
		}
		cartRepository.save(modelMapper.map(cartItemDTO, CartItem.class));

		return ResponseEntity.ok(new MessageResponse("Cart is added successfully"));

	}

	@Override
	public ResponseEntity<?> updateCart(CartItemDTO cartItemDTO) throws ResourceNotFoundException {
		Optional<Products> optionalProduct = productRepository.findById(cartItemDTO.getProducts().getProId());
		if (!optionalProduct.isPresent()) {
			throw new ResourceNotFoundException("Product not found");
		}
		Optional<Users> optionalAccount = userRepository.findById(cartItemDTO.getUsers().getUserId());
		if (!optionalAccount.isPresent()) {
			throw new ResourceNotFoundException("Account not found");
		}
		Optional<CartItem> optionalCart = cartRepository.findById(cartItemDTO.getCartItemId());
		if (optionalCart.isPresent()) {
			CartItem cart = optionalCart.get();
			if (cart.getQuantity() == 0) {
				cartRepository.delete(cart);
			}
			cart.setQuantity(cartItemDTO.getQuantity());
			cartRepository.save(cart);
			return ResponseEntity.ok(new MessageResponse("Cart is updated successfully"));
		}
		throw new ResourceNotFoundException("Cart not found");
	}

	@Override
	public ResponseEntity<?> deleteCart(Long userId) throws ResourceNotFoundException {
		Optional<Users> optionalAccount = userRepository.findById(userId);
		if (!optionalAccount.isPresent()) {
			throw new ResourceNotFoundException("Account not found");
		}
		List<CartItem> list = cartRepository.findByIdAccount(userId);
		cartRepository.deleteAll(list);
		return ResponseEntity.ok(new MessageResponse("Deleted successfully"));
	}

}
