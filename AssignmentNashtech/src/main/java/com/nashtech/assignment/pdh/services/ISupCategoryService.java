package com.nashtech.assignment.pdh.services;

import java.util.List;

import com.nashtech.assignment.pdh.entities.SupCategories;

public interface ISupCategoryService {
	
	public SupCategories addSupCategories(SupCategories supCategories);
	
	public SupCategories updateSupCategories(long id,SupCategories supCategories);
	
	public boolean deleteSupCategory(long id);
	
	public List<SupCategories> getAllSupCategories();

}
