package com.nashtech.assignment.pdh.services.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.repositories.CategoryRepository;
import com.nashtech.assignment.pdh.services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Categories addCategories(@Valid Categories categories) {
		return categoryRepository.save(categories);
	}

	@Override
	public Categories updateCategories(long id, Categories categories) {
		if (categories != null) {
			@SuppressWarnings("deprecation")
			Categories categoriesById = categoryRepository.getById(id);
			if (categoriesById != null) {
				categoriesById.setCategoryName(categories.getCategoryName());

				return categoryRepository.save(categoriesById);
			}
		}
		return null;
	}

	@Override
	public void deleteCategory(long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<Categories> getAllCategories() {

		return categoryRepository.findAll();
	}

	@Override
	public Optional<Categories> findCategoriesById(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

}
