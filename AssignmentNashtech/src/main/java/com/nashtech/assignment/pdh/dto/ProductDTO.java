package com.nashtech.assignment.pdh.dto;

import java.util.List;

import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.SupCategories;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	private Long proId;
	private String proName;
	private float proPrice;
	private String proImage;
	private String proDiscreption;
	private int proQuantity;
	private Categories categories;
	private SupCategories supCategories;

}
