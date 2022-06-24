package com.nashtech.assignment.pdh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.services.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService iProductService;
	
	@GetMapping("/sup")
	public String test() {
		return "Test";
	}
	
	@GetMapping("/list")
	private List<Products> productList(){
		return iProductService.getAllProducts();
	}
}
