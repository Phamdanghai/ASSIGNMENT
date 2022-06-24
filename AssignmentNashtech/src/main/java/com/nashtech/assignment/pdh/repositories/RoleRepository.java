package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.pdh.entities.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
