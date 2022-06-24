package com.nashtech.assignment.pdh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.pdh.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> getUserEmail(String email);
}
