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

import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.services.ICategory;

@RestController
@RequestMapping("/cate")
public class UserController {

	@GetMapping("/")
	public String test() {
		return "Test";
	}

	@Autowired
	private ICategory iCategory;

	// add cate
	@PostMapping("/add")
	public Categories addCategories(@RequestBody Categories cate) {
		return iCategory.addCate(cate);
	}

	// add cate
	@PutMapping("/update")
	public Categories updateCategories(@RequestParam("id") long id, @RequestBody Categories cate) {
		return iCategory.updateCategories(id, cate);
	}

	//delete cate
	@DeleteMapping("/delete/{id}")
	private boolean deleteCategory(@PathVariable("id")long id) {
		return iCategory.deleteCategory(id);
	}
	
	@GetMapping("/list")
	private List<Categories> list() {

		return iCategory.getAllCategories();
	}

}
