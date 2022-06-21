package com.nashtech.assignment.pdh.services;

import java.util.List;

import com.nashtech.assignment.pdh.entities.Categories;


public interface ICategoryService {
	//add category
	public Categories addCate(Categories categories);
	
	// update category
	public Categories updateCategories(long id, Categories categories);
	
	//delete category
	public boolean deleteCategory(long id);
	
	//list category
	public List<Categories> getAllCategories();
	
	//get 1 categpry
	public Categories getOneCategories(long id);
}
