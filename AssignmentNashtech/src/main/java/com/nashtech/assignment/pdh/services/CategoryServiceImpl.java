package com.nashtech.assignment.pdh.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Categories addCate(@Valid Categories categories) {
		if(categories!=null) {
			return categoryRepository.save(categories);
		}
		return null;
	}

	@Override
	public Categories updateCategories(long id, Categories categories) {
		if(categories!=null) {
			@SuppressWarnings("deprecation")
			Categories categories1 = categoryRepository.getById(id);
			if(categories1!=null) {
				categories1.setCategoryName(categories.getCategoryName());
				
				return categoryRepository.save(categories1);
			}
		}
		return null;
	}

	@Override
	public boolean deleteCategory(long id) {
		if(id >= 1) {
			@SuppressWarnings("deprecation")
			Categories categories = categoryRepository.getById(id);
			if(categories!= null) {
				categoryRepository.delete(categories);
				
			}
			return true;
		}
		return false;
	}

	@Override
	public List<Categories> getAllCategories() {
		
		return categoryRepository.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Categories getOneCategories(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.getById(id);
	}
	
}
