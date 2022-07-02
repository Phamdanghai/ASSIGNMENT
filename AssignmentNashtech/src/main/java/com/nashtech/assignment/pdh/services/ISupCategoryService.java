package com.nashtech.assignment.pdh.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.SupCategories;


public interface ISupCategoryService {
	
	 SupCategories addSupCategories(SupCategories supCategories);
	
	 SupCategories updateSupCategories(long id,SupCategories supCategories);
	
	 void deleteSupCategory(long id);
	
	 List<SupCategories> getAllSupCategories();
	 
	 Optional<SupCategories> findSupCategoriesById(long id);

}
