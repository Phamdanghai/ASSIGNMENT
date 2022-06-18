package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.pdh.entities.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
