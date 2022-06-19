package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.pdh.entities.Information;

public interface InformationRepository extends JpaRepository<Information, Long> {

}
