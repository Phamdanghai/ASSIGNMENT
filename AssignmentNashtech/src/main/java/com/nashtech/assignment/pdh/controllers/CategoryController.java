package com.nashtech.assignment.pdh.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.dto.CategoryDto;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.SupCategories;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.services.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

//	@GetMapping("/")
//	public String test() {
//		return "Test";
//	}
	@Autowired
	private ICategoryService iCategoryService;
	
//	@Autowired
//	private ModelMapper mapper;
//	
//	public CategoryController(ICategoryService categoryService) {
//		super();
//		this.iCategoryService = categoryService;
//	}
//
//	// add cate
//	@PostMapping("/")
//	public ResponseEntity<CategoryDto> addCategories(@RequestBody@Valid CategoryDto cateDto) {
//		Categories categoriesRequest = mapper.map(cateDto, Categories.class);
//		
//		Categories categories = iCategoryService.addCate(categoriesRequest);
//		
//		CategoryDto categoryResponse = mapper.map(categories, CategoryDto.class);
//		return new ResponseEntity<CategoryDto>(categoryResponse,HttpStatus.CREATED);
//	}
//
//	// add cate
//	@PutMapping("/{id}")
//	public ResponseEntity<CategoryDto> updateCategories(@PathVariable long id, @RequestBody @Valid CategoryDto cateDto){
//		//Convert DTO to Entity'
//		Categories categoryRequest = mapper.map(cateDto, Categories.class);
//		
//		Categories categories = iCategoryService.updateCategories(id, categoryRequest);
//		
//		//entity to DTO
//		CategoryDto categoryResponse = mapper.map(categories, CategoryDto.class);
//		
//		return ResponseEntity.ok().body(categoryResponse);
//	}
//
//	//delete cate
//	@DeleteMapping("/{id}")
//	private boolean deleteCategory(@PathVariable("id")long id) {
//		return iCategoryService.deleteCategory(id);
//	}
	
//	@GetMapping("/")
//	private List<Categories> list() {
//
////		return iCategoryService.getAllCategories().stream().map(cate -> mapper.map(cate, CategoryDto.class))
////				.collect(Collectors.toList());
//		return iCategoryService.getAllCategories();
//	}
	
	@PostMapping("/")
	public ResponseEntity<Categories> addCategories(@RequestBody Categories categories) {
//		return iCategoryService.addCategories(categories);
		return new ResponseEntity<>(iCategoryService.addCategories(categories),HttpStatus.OK);
	}

	// add cate
	@PutMapping("/{id}")
	public ResponseEntity<Categories> updateCategories(@PathVariable("id") long id, @RequestBody Categories categories) {
		Optional<Categories> categoryOptional= iCategoryService.findCategoriesById(id);
		
		return categoryOptional.map(categoryById ->{
			categories.setCategoryId(categoryById.getCategoryId());
			return new ResponseEntity<>(iCategoryService.updateCategories(id, categories), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
//		return iCategoryService.updateCategories(id, categories);
	}

	// delete cate
	@DeleteMapping("/{id}")
	private ResponseEntity<Categories> deleteCategory(@PathVariable long id) {
		Optional<Categories> categoryOptional = iCategoryService.findCategoriesById(id);
        return categoryOptional.map(category -> {
            iCategoryService.deleteCategory(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//		return iCategoryService.deleteCategory(id);
	}

	@GetMapping("/")
	private ResponseEntity<List<Categories>> listCategory() {

		return new ResponseEntity<>(iCategoryService.getAllCategories(),HttpStatus.OK);
//		return iCategoryService.getAllCategories();
	}
	
	

}
