package com.nashtech.assignment.pdh.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.nashtech.assignment.pdh.dto.SupCategoryDTO;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.entities.SupCategories;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.services.IProductService;
import com.nashtech.assignment.pdh.services.ISupCategoryService;

@RestController
@RequestMapping("/supcategory")
public class SupCategoryController {

	@Autowired
	private ISupCategoryService iSupCategoryService;

	// add cate
	@PostMapping("/")
	public SupCategoryDTO addCategories(@RequestBody SupCategoryDTO supCategoryDTO) {
		return iSupCategoryService.addSupCategories(supCategoryDTO);
	}

	// add cate
	@PutMapping("/")
	public ResponseEntity<?> updateCategories(@RequestParam long id, @RequestBody SupCategoryDTO supCategoryDTO)
			throws ResourceNotFoundException {
		iSupCategoryService.updateSupCategories(id, supCategoryDTO);
		return ResponseEntity.status(HttpStatus.OK).body(String.format("update supCategory successfully"));
	}

	// delete cate
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable long id) throws ResourceNotFoundException {
		iSupCategoryService.deleteSupCategory(id);
		return ResponseEntity.ok().body(String.format("Delete supCategory successfully!"));

	}

	@GetMapping("/")
	public List<SupCategoryDTO> list() {
		return iSupCategoryService.getAllSupCategories();
	}

	public ResponseEntity<?> getSupCategoryById(@PathVariable Long id) throws ResourceNotFoundException {
		iSupCategoryService.getSupCategoriesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(String.format("List category successfully"));
	}
}
