package com.nashtech.assignment.pdh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
	public Optional<Roles> findByRoleName(String roleName);
}
