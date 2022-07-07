package com.nashtech.assignment.pdh.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.CartItem;
import com.nashtech.assignment.pdh.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> getUserEmail(String email);

	@Query("Select a.cartItems from Users a where a.userId = :idUser ")
	public List<CartItem> findCartByIdAccount(Long idUser);
}
