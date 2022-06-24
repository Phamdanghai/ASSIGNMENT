package com.nashtech.assignment.pdh.services;

import java.util.List;

import com.nashtech.assignment.pdh.entities.Categories;


public interface ICategoryService {
	// add category
	Categories addCate(Categories categories);

	// update category
	Categories updateCategories(long id, Categories categories);

	// delete category
	boolean deleteCategory(long id);

	// list category
	List<Categories> getAllCategories();

	// get 1 categpry
	Categories getOneCategories(long id);
}
