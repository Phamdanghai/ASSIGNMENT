package com.nashtech.assignment.pdh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.CategoryDTO;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;

@Service
public interface ICategoryService {
	// add category
	CategoryDTO addCategories(CategoryDTO categorieDto);

	// get 1 categpry
	Categories getCategoriesById(long id) throws ResourceNotFoundException;

	// list category
	List<CategoryDTO> getAllCategories();

	// update category
	CategoryDTO updateCategories(long id, CategoryDTO categoryDTO) throws ResourceNotFoundException;

	// delete category
	ResponseEntity<?> deleteCategory(long id) throws ResourceNotFoundException;

}
