package com.nashtech.assignment.pdh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
