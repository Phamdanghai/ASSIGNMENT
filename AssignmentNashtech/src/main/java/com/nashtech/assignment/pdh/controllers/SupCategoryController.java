package com.nashtech.assignment.pdh.controllers;

import java.util.List;
import java.util.Optional;

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

import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.SupCategories;

import com.nashtech.assignment.pdh.services.ISupCategoryService;

@RestController
@RequestMapping("/supcategory")
public class SupCategoryController {
//	@GetMapping("/sup")
//	public String test() {
//		return "Test";
//	}

	@Autowired
	private ISupCategoryService iSupCategoryService;

	// add cate
	@PostMapping("/")
	public ResponseEntity<SupCategories> addCategories(@RequestBody SupCategories supCategories) {
		return new ResponseEntity<>(iSupCategoryService.addSupCategories(supCategories), HttpStatus.OK);
//		return iSupCategoryService.addSupCategories(supCategories);
	}

	// add cate
	@PutMapping("/")
	public ResponseEntity<SupCategories> updateCategories(@RequestParam("id") long id, @RequestBody SupCategories supCategories) {
		Optional<SupCategories> supCategoryOptional = iSupCategoryService.findSupCategoriesById(id);

		return supCategoryOptional.map(supCategoryById -> {
			supCategories.setSupCateId(supCategoryById.getSupCateId());
			return new ResponseEntity<>(iSupCategoryService.updateSupCategories(id, supCategories), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//		return iSupCategoryService.updateSupCategories(id, supCategories);
	}

	// delete cate
	@DeleteMapping("/{id}")
	private ResponseEntity<SupCategories> deleteCategory(@PathVariable("id") long id) {
		Optional<SupCategories> supCategoryOptional = iSupCategoryService.findSupCategoriesById(id);
		return supCategoryOptional.map(supCategoryById -> {
			iSupCategoryService.deleteSupCategory(id);
			return new ResponseEntity<>(supCategoryById,HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//		return iSupCategoryService.deleteSupCategory(id);
	}

	@GetMapping("/")
	private List<SupCategories> list() {

//		return new ResponseEntity<>(iSupCategoryService.getAllSupCategories(),HttpStatus.OK);
		return iSupCategoryService.getAllSupCategories();
	}
}
