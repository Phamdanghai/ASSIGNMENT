package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.SupCategories;

@Repository
public interface SupCategoryRepository extends JpaRepository<SupCategories, Long> {

}
