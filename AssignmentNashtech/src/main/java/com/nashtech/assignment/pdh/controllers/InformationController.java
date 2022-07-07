package com.nashtech.assignment.pdh.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nashtech.assignment.pdh.dto.InformationDTO;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.services.IInformationService;

@RestController
@RequestMapping("/information")
public class InformationController {
	@Autowired
	IInformationService iInformationService ;
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateInformation(@PathVariable("id") Long id,
			@Valid @RequestBody InformationDTO informationDto) throws ResourceNotFoundException{
		return iInformationService.updateInformation(id, informationDto);
	}
}
