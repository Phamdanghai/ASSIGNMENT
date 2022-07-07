package com.nashtech.assignment.pdh.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.UserDTO;
import com.nashtech.assignment.pdh.dto.UserUpdateDTO;
import com.nashtech.assignment.pdh.entities.Information;
import com.nashtech.assignment.pdh.entities.Users;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;

@Service
public interface IUserService {
	public ResponseEntity<?> updateAccount(long id, UserUpdateDTO userUpdateDTO) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteAccount(long id) throws ResourceNotFoundException;

	public List<Users> getAllAccount();

	public ResponseEntity<?> getOrdersbyIdAccount(Long idAccount) throws ResourceNotFoundException;
}
