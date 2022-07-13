package com.nashtech.assignment.pdh.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nashtech.assignment.pdh.dto.CategoryDTO;
import com.nashtech.assignment.pdh.dto.ProductDTO;
import com.nashtech.assignment.pdh.dto.SupCategoryDTO;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.entities.SupCategories;
import com.nashtech.assignment.pdh.repositories.CategoryRepository;
import com.nashtech.assignment.pdh.repositories.ProductRepository;
import com.nashtech.assignment.pdh.repositories.SupCategoryRepository;
import com.nashtech.assignment.pdh.services.impl.ProductServiceImpl;

public class ProductServiceImplTest {
	ProductRepository productRepository;
	CategoryRepository categoryRepository;
	SupCategoryRepository supCategoryRepository;

	ProductServiceImpl productServiceImpl;
	CategoryDTO categoryDTO;
	SupCategoryDTO supCategoryDTO;
	ProductDTO productDTO;

	Categories categories;
	SupCategories supCategories;
	Products products;

	ModelMapper modelMapper;

	@BeforeEach
	void beforeEach() {
		productRepository = mock(ProductRepository.class);
		categoryRepository = mock(CategoryRepository.class);
		supCategoryRepository = mock(SupCategoryRepository.class);

		productServiceImpl = new ProductServiceImpl(productRepository, categoryRepository, supCategoryRepository,
				modelMapper);

		categories = mock(Categories.class);
		supCategories = mock(SupCategories.class);

		products = mock(Products.class);

		when(productRepository.save(products)).thenReturn(products);
		when(modelMapper.map(productDTO, Products.class)).thenReturn(products);
	}

	@Test
	public void getAllProducts_ReturnHttpOk_WhenDataValid() {
		List<Products> list = new ArrayList<Products>();
		list.add(products);

		when(productRepository.findAll()).thenReturn(list);
		when(modelMapper.map(products, ProductDTO.class)).thenReturn(productDTO);
		ResponseEntity<?> result = productServiceImpl.getAllProduct();
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	public void getProduct_ReturnProductDto_WhenDataValid() {
		when(productRepository.findById(1L)).thenReturn(Optional.of(products));
		when(modelMapper.map(products, ProductDTO.class)).thenReturn(productDTO);
		ProductDTO result = productServiceImpl.findByIdProduct(1L);
		assertThat(result, is(productDTO));
	}

	@Test
	public void addProduct_ShouldReturnStatusOk_WhenDataValid() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProName("coffee");
		productDTO.setProPrice(10000);
		productDTO.setProImage("test");
		productDTO.setProDiscreption("test");
		productDTO.setProQuantity(100);
		productDTO.setCategories(new ModelMapper().map(categories, CategoryDTO.class));
		productDTO.setSupCategories(new ModelMapper().map(supCategories, SupCategoryDTO.class));
		when(categoryRepository.findById(productDTO.getCategories().getCategoryId()))
				.thenReturn(Optional.of(categories));

		when(supCategoryRepository.findById(productDTO.getSupCategories().getSupCateId()))
				.thenReturn(Optional.of(supCategories));

		when(productRepository.save(new ModelMapper().map(productDTO, Products.class))).thenReturn(products);
		new ModelMapper().map(products, ProductDTO.class);
		new ModelMapper().map(categories, CategoryDTO.class);
		new ModelMapper().map(supCategories, SupCategoryDTO.class);

		ResponseEntity<?> responseEntity = productServiceImpl.addProduct(productDTO);
		System.out.println(responseEntity);
		assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

	}

}
