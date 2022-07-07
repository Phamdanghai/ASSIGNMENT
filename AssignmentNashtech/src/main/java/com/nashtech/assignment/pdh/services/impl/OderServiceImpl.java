package com.nashtech.assignment.pdh.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.nashtech.assignment.pdh.dto.OrderDTO;
import com.nashtech.assignment.pdh.dto.OrderDetailDTO;
import com.nashtech.assignment.pdh.entities.OrderDetail;
import com.nashtech.assignment.pdh.entities.Orders;
import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.OrderDetailRepository;
import com.nashtech.assignment.pdh.repositories.OrderRepository;
import com.nashtech.assignment.pdh.repositories.ProductRepository;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.services.IOrderService;

@Component
public class OderServiceImpl implements IOrderService {

	@Autowired
	OrderRepository orderRepository;
	private OrderDetailRepository orderDetailRepository;
	private ProductRepository productRepository;
	private ModelMapper modelMapper;

	@Override
	public OrderDTO findByIdOrder(long id) throws ResourceNotFoundException {
		Optional<Orders> optional = orderRepository.findById(id);
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException("Order not found");
		}
		Orders order = optional.get();
		return modelMapper.map(order, OrderDTO.class);
	}

	@Override
	public ResponseEntity<?> getAllOrder() {
		List<Orders> list = orderRepository.findAll();
		List<OrderDTO> listDto = new ArrayList<OrderDTO>();
		list.forEach(s -> listDto.add(modelMapper.map(s, OrderDTO.class)));

		return ResponseEntity.ok(listDto);
	}

	@Override
	public ResponseEntity<?> addOrder(OrderDTO orderDTO) throws ResourceNotFoundException {
		Orders order = modelMapper.map(orderDTO, Orders.class);
		Optional<Orders> optionalOrder = orderRepository.findById(orderDTO.getOrId());
		if(optionalOrder.isPresent()) {
			throw new ResourceNotFoundException("Don't add Order");
		}
		orderRepository.save(order);
		List<OrderDetail> listOrderdetails = new ArrayList<>();
		OrderDetail orderdetails;
		
		for(OrderDetailDTO s : orderDTO.getDetails()) {
			Long idProduct =s.getProducts().getProId();
			Optional<Products> optionalProduct = productRepository.findById(idProduct);
			if(!optionalProduct.isPresent()) {
				throw new ResourceNotFoundException("Product not found");
			}
			orderdetails = modelMapper.map(s, OrderDetail.class);
			orderdetails.setProducts(productRepository.findByIdProduct(idProduct));
			orderdetails.setOrders(order);
			listOrderdetails.add(orderdetails);
		}
		orderDetailRepository.saveAll(listOrderdetails);
		return ResponseEntity.ok(new MessageResponse("The order was added successfully"));

	}

}
