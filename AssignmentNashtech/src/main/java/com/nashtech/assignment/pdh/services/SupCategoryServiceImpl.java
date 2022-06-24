package com.nashtech.assignment.pdh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.entities.SupCategories;
import com.nashtech.assignment.pdh.repositories.SupCategoryRepository;

@Service
public class SupCategoryServiceImpl implements ISupCategoryService{

	@Autowired
	private SupCategoryRepository supCategoryRepository;
	@Override
	public SupCategories addSupCategories(SupCategories supCategories) {
		if(supCategories!=null) {
			return supCategoryRepository.save(supCategories);
		}
		return null;
	}

	@Override
	public SupCategories updateSupCategories(long id, SupCategories supCategories) {
		if(supCategories!=null) {
			@SuppressWarnings("deprecation")
			SupCategories supCategories2 = supCategoryRepository.getById(id);
			if(supCategories2!=null) {
				supCategories2.setSupCateName(supCategories.getSupCateName());
				return supCategoryRepository.save(supCategories2);
			}
		}
		return null;
	}

	@Override
	public boolean deleteSupCategory(long id) {
		if(id>=1) {
			@SuppressWarnings("deprecation")
			SupCategories supCategories = supCategoryRepository.getById(id);
			if(supCategories!=null) {
				supCategoryRepository.delete(supCategories);
			}
			return true;
		}
		return false;
	}

	@Override
	public List<SupCategories> getAllSupCategories() {
		
		return supCategoryRepository.findAll();
	}

}
