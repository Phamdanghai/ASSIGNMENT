package com.nashtech.assignment.pdh.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.CategoryDTO;
import com.nashtech.assignment.pdh.dto.SupCategoryDTO;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.SupCategories;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.SupCategoryRepository;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.services.ISupCategoryService;

@Component
public class SupCategoryServiceImpl implements ISupCategoryService {

	@Autowired
	private SupCategoryRepository supCategoryRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public SupCategoryDTO addSupCategories(SupCategoryDTO supCategoryDTO) {
		SupCategories supCategories = supCategoryRepository.save(modelMapper.map(supCategoryDTO, SupCategories.class));
		return modelMapper.map(supCategories, SupCategoryDTO.class);
	}

	@Override
	public SupCategoryDTO updateSupCategories(long id, SupCategoryDTO supCategoryDTO) throws ResourceNotFoundException {
		Optional<SupCategories> supCategoriesOptional = supCategoryRepository.findById(id);
		if (supCategoriesOptional.isPresent()) {
			SupCategories SupCategories = supCategoriesOptional.get();
			modelMapper.map(supCategoryDTO, SupCategories);
			SupCategories = supCategoryRepository.save(SupCategories);
			return modelMapper.map(SupCategories, SupCategoryDTO.class);
		}
		throw new ResourceNotFoundException("Category not found");
	}

	@Override
	public ResponseEntity<?> deleteSupCategory(long id) throws ResourceNotFoundException {

		Optional<SupCategories> supCategoriesOptional = supCategoryRepository.findById(id);
		if (supCategoriesOptional.isPresent()) {
			SupCategories SupCategories = supCategoriesOptional.get();
			supCategoryRepository.delete(SupCategories);
			return ResponseEntity.ok(new MessageResponse("The supCategory deleted successfully"));
		}
		throw new ResourceNotFoundException("Category not found");

	}

	@Override
	public List<SupCategoryDTO> getAllSupCategories() {

		List<SupCategories> list = supCategoryRepository.findAll();
		List<SupCategoryDTO> listDto = new ArrayList<SupCategoryDTO>();
		list.forEach(c -> listDto.add(modelMapper.map(c, SupCategoryDTO.class)));
		return listDto;
	}

	@Override
	public SupCategories getSupCategoriesById(long id) {
		// TODO Auto-generated method stub
		return supCategoryRepository.getById(id);
	}

}
