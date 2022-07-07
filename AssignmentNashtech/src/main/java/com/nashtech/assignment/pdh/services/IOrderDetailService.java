package com.nashtech.assignment.pdh.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;

@Service
public interface IOrderDetailService {
	List<IOrderDetailService> findByIdOrder(Long idOrder) throws ResourceNotFoundException;
}
