package com.nashtech.assignment.pdh.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.entities.Roles;

@Service
public interface IRoleService {
	List<Roles> getRoles();

    Optional<Roles> getRoleId(Long id);

    Roles createRoles(Roles roles);
}
