package com.nashtech.assignment.pdh.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.dto.CategoryDTO;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.services.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoryService iCategoryService;

	@PostMapping("/")
	public CategoryDTO addCategories(@RequestBody CategoryDTO categoryDTO) {
//		return iCategoryService.addCategories(categories);
//		iCategoryService.addCategories(categories);
//		return ResponseEntity.ok(new MessageResponse("Category registered successfully "));
//		return new ResponseEntity<>(iCategoryService.addCategories(categories), HttpStatus.OK);
		return iCategoryService.addCategories(categoryDTO);
	}

	// add cate
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategories(@PathVariable("id") long id, @RequestBody CategoryDTO categoryDTO)
			throws ResourceNotFoundException {
//		Optional<Categories> categoryOptional= iCategoryService.findCategoriesById(id);
//		
//		return categoryOptional.map(categoryById ->{
//			categories.setCategoryId(categoryById.getCategoryId());
//			return new ResponseEntity<>(iCategoryService.updateCategories(id, categories), HttpStatus.OK);
//		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//		if (iCategoryService.getCategoriesById(id).isEmpty())
//			throw new ResourceNotFoundException("Category not found");
//		iCategoryService.updateCategories(id, categories);
//		return ResponseEntity.ok().body(String.format("update category successfully"));
		iCategoryService.updateCategories(id, categoryDTO);
		return ResponseEntity.status(HttpStatus.OK).body(String.format("update category successfully"));
	}

	// delete cate
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable long id) throws ResourceNotFoundException {
//		Optional<Categories> categoryOptional = iCategoryService.findCategoriesById(id);
//        return categoryOptional.map(category -> {
//            iCategoryService.deleteCategory(id);
//            return new ResponseEntity<>(category, HttpStatus.OK);
//        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//		Optional<Categories> categoryOptional = iCategoryService.getCategoriesById(id);
//		if (!categoryOptional.isPresent()) {
//			throw new ResourceNotFoundException("Category not found");
//		}
//		Set<Products> list = categoryOptional.get().getProducts();
//		iProductService.deleteProductByCategoryId(id);
//		iCategoryService.deleteCategory(id);
//		return ResponseEntity.ok().body(String.format("Delete successfully!"));
		iCategoryService.deleteCategory(id);
		return ResponseEntity.status(HttpStatus.OK).body(String.format("delete category successfully"));

	}

	@GetMapping("/")
	public List<CategoryDTO> listCategory() {

		return iCategoryService.getAllCategories();
//		return ResponseEntity.status(HttpStatus.OK).body(String.format("List category successfully"));
//		return iCategoryService.getAllCategories();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable long id) throws ResourceNotFoundException {
//		return ResponseEntity.ok(iCategoryService.getCategoriesById(id));
//		Optional<Categories> categoryOptional = iCategoryService.getCategoriesById(id);
//		if (categoryOptional.isEmpty())
//			throw new ResourceNotFoundException("Category is not found");
//		return ResponseEntity.ok().body(iCategoryService.getCategoriesById(id));
		iCategoryService.getCategoriesById(id);
		return ResponseEntity.status(HttpStatus.OK).body(String.format("List category successfully"));

	}

}
