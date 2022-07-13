package com.nashtech.assignment.pdh.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.dto.ProductDTO;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.services.IProductService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	private IProductService productServices;

	@PostMapping("/")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO) {
		return productServices.addProduct(productDTO);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @Valid @RequestBody ProductDTO productDTO) throws ResourceNotFoundException {

		return productServices.updateProduct(id, productDTO);

	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) throws ResourceNotFoundException {
		return productServices.deleteProduct(id);
	}

	@GetMapping("/")
	@PreAuthorize("hasAuthority('Admin') or hasAuthority('Customer')")
	public ResponseEntity<?> getAllProducts() {
		return productServices.getAllProduct();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin') or hasAuthority('Customer')")
	public ResponseEntity<?> getAllProductsByCategory(@PathVariable("id") long id) {
		productServices.getAllProductbyCategory(id);
		return ResponseEntity.status(HttpStatus.OK).body("List product successfully");
	}
}
