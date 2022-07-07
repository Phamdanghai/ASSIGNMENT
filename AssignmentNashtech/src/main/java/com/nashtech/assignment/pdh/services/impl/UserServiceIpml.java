package com.nashtech.assignment.pdh.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.nashtech.assignment.pdh.dto.OrderDTO;
import com.nashtech.assignment.pdh.dto.UserDTO;
import com.nashtech.assignment.pdh.dto.UserUpdateDTO;
import com.nashtech.assignment.pdh.entities.Information;
import com.nashtech.assignment.pdh.entities.Roles;
import com.nashtech.assignment.pdh.entities.Users;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.RoleRepository;
import com.nashtech.assignment.pdh.repositories.UserRepository;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.services.IUserService;

@Component
public class UserServiceIpml implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> updateAccount(long id, UserUpdateDTO userUpdateDTO) throws ResourceNotFoundException {
		Optional<Users> optional = userRepository.findById(id);
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException("Account is not found");
		}
		Users account = optional.get();
		account.setUserPassword(userUpdateDTO.getPassword());
		userRepository.save(account);

		return ResponseEntity.ok(new MessageResponse("Update password successfully"));
	}

	@Override
	public ResponseEntity<?> deleteAccount(long id) throws ResourceNotFoundException {
		Optional<Users> optional = userRepository.findById(id);
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException("Account is not found");
		}
		Users account = optional.get();
		userRepository.delete(account);
		return ResponseEntity.ok(new MessageResponse("The account delete successfully"));
	}

	@Override
	public List<Users> getAllAccount() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public ResponseEntity<?> getOrdersbyIdAccount(Long idAccount) throws ResourceNotFoundException {
		Optional<Users> optional = userRepository.findById(idAccount);
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException("Account not found");
		}
		Users account = optional.get();
		if (account.getOrders().size() == 0) {
			return ResponseEntity.ok("Account don't have orders");
		}
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		account.getOrders().forEach(order -> list.add(modelMapper.map(order, OrderDTO.class)));
		return ResponseEntity.ok(list);
	}

}
