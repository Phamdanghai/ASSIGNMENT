package com.nashtech.assignment.pdh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.ProductDTO;
import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
@Service
public interface IProductService {

	ResponseEntity<?> addProduct(ProductDTO productDtO);

	ResponseEntity<?> updateProduct(long id, ProductDTO productDTO) throws ResourceNotFoundException;

	ResponseEntity<?> deleteProduct(long id) throws ResourceNotFoundException;

	ResponseEntity<?> getAllProduct();

	List<ProductDTO> getAllProductbyCategory(long id);

	List<ProductDTO> getAllProductbySupCategory(long id);

	ProductDTO findByIdProduct(long id) throws ResourceNotFoundException;
}
