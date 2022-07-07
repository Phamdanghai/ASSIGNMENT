package com.nashtech.assignment.pdh.dto;

import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.entities.Users;

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
public class CartItemDTO {

	private Long cartItemId;

	private int quantity;

	private Users users;

	private Products products;

}
