package com.nashtech.assignment.pdh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.entities.SupCategories;

import com.nashtech.assignment.pdh.services.ISupCategoryService;

@RestController
@RequestMapping("/supcate")
public class SupCategoryController {
	@GetMapping("/sup")
	public String test() {
		return "Test";
	}

	@Autowired
	private ISupCategoryService iSupCategoryService;

	// add cate
	@PostMapping("/")
	public SupCategories addCategories(@RequestBody SupCategories supCate) {
		return iSupCategoryService.addSupCategories(supCate);
	}

	// add cate
	@PutMapping("/")
	public SupCategories updateCategories(@RequestParam("id") long id, @RequestBody SupCategories supCate) {
		return iSupCategoryService.updateSupCategories(id, supCate);
	}

	// delete cate
	@DeleteMapping("/{id}")
	private boolean deleteCategory(@PathVariable("id") long id) {
		return iSupCategoryService.deleteSupCategory(id);
	}

	@GetMapping("/")
	private List<SupCategories> list() {

		return iSupCategoryService.getAllSupCategories();
	}
}
