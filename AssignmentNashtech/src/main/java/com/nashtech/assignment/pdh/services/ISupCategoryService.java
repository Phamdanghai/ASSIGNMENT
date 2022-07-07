package com.nashtech.assignment.pdh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.SupCategoryDTO;
import com.nashtech.assignment.pdh.entities.SupCategories;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;

@Service
public interface ISupCategoryService {

	SupCategoryDTO addSupCategories(SupCategoryDTO supCategoryDTO);

	SupCategoryDTO updateSupCategories(long id, SupCategoryDTO supCategoryDTO) throws ResourceNotFoundException;

	ResponseEntity<?> deleteSupCategory(long id) throws ResourceNotFoundException;

	List<SupCategoryDTO> getAllSupCategories();

	SupCategories getSupCategoriesById(long id) throws ResourceNotFoundException;

}
