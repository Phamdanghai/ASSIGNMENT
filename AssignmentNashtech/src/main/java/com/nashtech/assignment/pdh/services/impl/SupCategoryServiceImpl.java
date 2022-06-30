package com.nashtech.assignment.pdh.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.entities.SupCategories;
import com.nashtech.assignment.pdh.repositories.SupCategoryRepository;
import com.nashtech.assignment.pdh.services.ISupCategoryService;

@Service
public class SupCategoryServiceImpl implements ISupCategoryService {

	@Autowired
	private SupCategoryRepository supCategoryRepository;

	@Override
	public SupCategories addSupCategories(SupCategories supCategories) {
		return supCategoryRepository.save(supCategories);
	}

	@Override
	public SupCategories updateSupCategories(long id, SupCategories supCategories) {
		if (supCategories != null) {
			@SuppressWarnings("deprecation")
			SupCategories supCategoriesById = supCategoryRepository.getById(id);
			if (supCategoriesById != null) {
				supCategoriesById.setSupCateName(supCategories.getSupCateName());
				return supCategoryRepository.save(supCategoriesById);
			}
		}
		return null;
	}

	@Override
	public void deleteSupCategory(long id) {

		supCategoryRepository.deleteById(id);

	}

	@Override
	public List<SupCategories> getAllSupCategories() {

		return supCategoryRepository.findAll();
	}

	@Override
	public Optional<SupCategories> findSupCategoriesById(long id) {
		// TODO Auto-generated method stub
		return supCategoryRepository.findById(id);
	}

}
