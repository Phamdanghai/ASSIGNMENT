package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.pdh.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
