package com.nashtech.assignment.pdh.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.InformationDTO;
import com.nashtech.assignment.pdh.entities.Information;
import com.nashtech.assignment.pdh.entities.Users;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.InformationRepository;
import com.nashtech.assignment.pdh.repositories.UserRepository;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.services.IInformationService;

@Component
public class InformationSerciveIplm implements IInformationService {

	@Autowired
	InformationRepository informationRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> updateInformation(long id, InformationDTO informationDTO) throws ResourceNotFoundException {
		Optional<Information> optionalInformation = informationRepository.findById(id);
		if (!optionalInformation.isPresent()) {
			throw new ResourceNotFoundException("Information not found");
		}
		Optional<Users> userOptional = userRepository.findById(informationDTO.getUser().getUserId());
		if (!userOptional.isPresent()) {
			throw new ResourceNotFoundException("Account not found");
		}

		Information reInformation = optionalInformation.get();
		if (!reInformation.getInfPhone().equals(informationDTO.getInfPhone())) {
			Optional<Information> optionalPhoneNumber = informationRepository
					.findByPhoneNumber(informationDTO.getInfPhone());
			if (optionalPhoneNumber.isPresent()) {
				throw new IllegalArgumentException("Phone number is already taken");
			}
		}

		modelMapper.map(informationDTO, reInformation);
		informationRepository.save(reInformation);
		return ResponseEntity.ok(new MessageResponse("Update information successfully !"));

	}

}
