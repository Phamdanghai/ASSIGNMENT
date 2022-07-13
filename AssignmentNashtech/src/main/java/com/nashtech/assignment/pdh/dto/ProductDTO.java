package com.nashtech.assignment.pdh.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.SupCategories;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	private Long proId;
	@NotEmpty(message = "productName must not be empty")
	private String proName;
	@NotNull(message = "quantity must not be null")
	@Min(value = 0, message = "Quantity >= 1")
	private float proPrice;
	private String proImage;
	private String proDiscreption;
	@NotNull(message = "quantity must not be null")
	@Min(value = 0, message = "Quantity >= 1")
	private int proQuantity;
	private CategoryDTO categories;
	private SupCategoryDTO supCategories;

}
