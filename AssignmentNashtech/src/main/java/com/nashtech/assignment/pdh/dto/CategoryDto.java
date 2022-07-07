package com.nashtech.assignment.pdh.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
	private Long categoryId;
	@NotEmpty(message = "Category name must not be empty")
	private String categoryName;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

}
