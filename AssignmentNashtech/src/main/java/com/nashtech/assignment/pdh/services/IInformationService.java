package com.nashtech.assignment.pdh.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.InformationDTO;
import com.nashtech.assignment.pdh.dto.UserDTO;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;

@Service
public interface IInformationService {
	public ResponseEntity<?> updateInformation(long id, InformationDTO informationDTO) throws ResourceNotFoundException;
}
