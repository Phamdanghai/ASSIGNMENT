package com.nashtech.assignment.pdh.controllers;

import java.util.List;

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

import com.nashtech.assignment.pdh.dto.CategoryDTO;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.services.ICategoryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;

	@PostMapping("/")
	@PreAuthorize("hasAuthority('Admin')")
	public CategoryDTO addCategories(@RequestBody CategoryDTO categoryDTO) {
		return iCategoryService.addCategories(categoryDTO);
	}

	// add cate
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public CategoryDTO updateCategories(@PathVariable long id, @RequestBody CategoryDTO categoryDTO)
			throws ResourceNotFoundException {
		return iCategoryService.updateCategories(id, categoryDTO);
	}

	// delete cate
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('Admin')")
	public ResponseEntity<?> deleteCategory(@PathVariable long id) throws ResourceNotFoundException {

		iCategoryService.deleteCategory(id);
		return ResponseEntity.status(HttpStatus.OK).body(String.format("delete category successfully"));
	}

	@GetMapping("/")
	@PreAuthorize("hasAuthority('Admin')")
	public List<CategoryDTO> listCategory() {
		return iCategoryService.getAllCategories();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('Customer') or hasAuthority('Admin')")
	public Categories getCategoryById(@PathVariable long id) throws ResourceNotFoundException {
		return iCategoryService.getCategoriesById(id);
	}

}
