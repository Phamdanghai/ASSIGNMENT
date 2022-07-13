package com.nashtech.assignment.pdh.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nashtech.assignment.pdh.dto.CategoryDTO;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.CategoryRepository;
import com.nashtech.assignment.pdh.services.impl.CategoryServiceImpl;

public class CategoryServiceTest {
	CategoryRepository categoryRepository;
	CategoryServiceImpl categoryServiceImpl;
	ModelMapper modelMapper;
	CategoryDTO categoryDTO;
	Categories categories;

	@BeforeEach
	void beforeEach() {
		categoryRepository = mock(CategoryRepository.class);
		modelMapper = mock(ModelMapper.class);
		categoryServiceImpl = new CategoryServiceImpl(categoryRepository, modelMapper);
		categoryDTO = mock(CategoryDTO.class);
		categories = mock(Categories.class);

		when(categoryRepository.save(categories)).thenReturn(categories);
		when(modelMapper.map(categoryDTO, Categories.class)).thenReturn(categories);
	}

	@Test
	void getCategory_ShouldReturnList_WhenDataValid() {
		// 1. create mock data
		List<Categories> list = new ArrayList<>();
		list.add(categories);

		when(categoryRepository.findAll()).thenReturn(list);

		List<CategoryDTO> result = categoryServiceImpl.getAllCategories();

		assertThat(result.size(), is(list.size()));
	}

	@Test
	void addCategory_ReturnCategoruDTO_WhenDataValid() {
		when(modelMapper.map(categories, CategoryDTO.class)).thenReturn(categoryDTO);
		CategoryDTO result = categoryServiceImpl.addCategories(categoryDTO);
		assertThat(result, is(categoryDTO));
	}

	@Test
	void deleteCategory_ReturnStatusOk_WhenDataValid() throws ResourceNotFoundException {
		when(categoryRepository.findById(1L)).thenReturn(Optional.of(categories));
		when(modelMapper.map(categories, CategoryDTO.class)).thenReturn(categoryDTO);
		ResponseEntity<?> result = categoryServiceImpl.deleteCategory(1L);
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}

	@Test
	void updateCategory_ReturnCategoryDTO_WhenDataValid() {
		when(categoryRepository.findById(1L)).thenReturn(Optional.of(categories));
		when(modelMapper.map(categories, CategoryDTO.class)).thenReturn(categoryDTO);
		CategoryDTO result = categoryServiceImpl.updateCategories(1L, categoryDTO);
		assertThat(result, is(categoryDTO));
	}

//	@Test
//	void deleteCategory_ReturnStatusOk_WhenDataNotValid() {
//		when(categoryRepository.findById(1L)).thenReturn(Optional.empty());
//
//		ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class,
//				() -> categoryServiceImpl.deleteCategory(1L));
//		assertThat(exception.getMessage(), is("Category not found"));
//	}
}
