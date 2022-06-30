package com.nashtech.assignment.pdh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.entities.Categories;

@Service
public interface ICategoryService {
	// add category
	Categories addCategories(Categories categories);

	// update category
	Categories updateCategories(long id, Categories categories);

	// delete category
	void deleteCategory(long id);

	// list category
	List<Categories> getAllCategories();

	// get 1 categpry
	Optional<Categories> findCategoriesById(long id);
}
