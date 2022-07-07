package com.nashtech.assignment.pdh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.CartItem;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
	@Query("SELECT c FROM CartItem c WHERE c.users.userId = :idUser")
	public List<CartItem> findByIdAccount(Long idUser);
}
