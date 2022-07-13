package com.nashtech.assignment.pdh.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.CategoryDTO;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.CategoryRepository;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.services.ICategoryService;

@Component
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ModelMapper modelMapper;

	public CategoryServiceImpl(CategoryRepository categoryRepository2, ModelMapper modelMapper2) {
		this.categoryRepository = categoryRepository2;
		this.modelMapper = modelMapper2;
	}

	@Override
	public CategoryDTO addCategories(@Valid CategoryDTO categoryDTO) {
		Categories categories = categoryRepository.save(modelMapper.map(categoryDTO, Categories.class));
		return modelMapper.map(categories, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategories(long id, CategoryDTO categoryDTO) throws ResourceNotFoundException {
		Optional<Categories> categoryOptional = categoryRepository.findById(id);
		if (categoryOptional.isPresent()) {
			Categories categories = categoryOptional.get();
			modelMapper.map(categoryDTO, categories);
			categories = categoryRepository.save(categories);

			return modelMapper.map(categories, CategoryDTO.class);
		}
		throw new ResourceNotFoundException("Category not found");

	}

	@Override
	public ResponseEntity<?> deleteCategory(long id) throws ResourceNotFoundException {
		Optional<Categories> categoryOptional = categoryRepository.findById(id);
		if (categoryOptional.isPresent()) {
			Categories category = categoryOptional.get();
			categoryRepository.delete(category);
			return ResponseEntity.ok(new MessageResponse("The category deleted successfully"));
		}
		throw new ResourceNotFoundException("Category not found");
	}

	@Override
	public List<CategoryDTO> getAllCategories() {

		List<Categories> list = categoryRepository.findAll();
		List<CategoryDTO> listDto = new ArrayList<CategoryDTO>();
		list.forEach(c -> listDto.add(modelMapper.map(c, CategoryDTO.class)));
		return listDto;
	}

	@Override
	public Categories getCategoriesById(long id) throws ResourceNotFoundException {
//		Categories categoriesById = categoryRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Category not exist with id: " + id));

//		return categoryRepository.save(categories);
		return categoryRepository.findCategoryByCategoryId(id);
	}

}
