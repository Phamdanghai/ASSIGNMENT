package com.nashtech.assignment.pdh.services;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.OrderDTO;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;

@Service
public interface IOrderService {
	public OrderDTO findByIdOrder(long id) throws ResourceNotFoundException;

	public ResponseEntity<?> getAllOrder();

	public ResponseEntity<?> addOrder(OrderDTO orderDTO) throws ResourceNotFoundException;
}
