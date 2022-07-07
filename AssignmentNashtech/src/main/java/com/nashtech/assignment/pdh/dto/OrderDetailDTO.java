package com.nashtech.assignment.pdh.dto;

import com.nashtech.assignment.pdh.entities.Products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailDTO {

	private Long ordId;
	private String ordName;
	private String ordPhone;
	private String ordDate;
	private float ordPrice;
	private int ordQuantity;
	private Products products;

}
