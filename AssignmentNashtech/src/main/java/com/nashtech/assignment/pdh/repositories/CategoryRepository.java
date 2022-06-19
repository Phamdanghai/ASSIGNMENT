package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nashtech.assignment.pdh.entities.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Long> {

}
