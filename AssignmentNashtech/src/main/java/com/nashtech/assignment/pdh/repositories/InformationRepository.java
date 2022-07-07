package com.nashtech.assignment.pdh.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.Information;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {

    @Query("SELECT i from Information i where i.infPhone = phoneNumber")
    public Optional<Information> findByPhoneNumber(String phoneNumber);
}
