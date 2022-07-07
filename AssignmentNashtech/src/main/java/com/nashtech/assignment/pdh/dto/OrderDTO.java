package com.nashtech.assignment.pdh.dto;

import java.util.Set;

import com.nashtech.assignment.pdh.entities.OrderDetail;
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
public class OrderDTO {

	private Long orId;
	private String orDate;
	private String orStatus;
	private Users users;
	private Set<OrderDetailDTO> details;

}
