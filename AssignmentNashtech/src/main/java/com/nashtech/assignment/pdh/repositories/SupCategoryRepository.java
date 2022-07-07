package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.SupCategories;

@Repository
public interface SupCategoryRepository extends JpaRepository<SupCategories, Long> {
	@Query("SELECT s FROM SupCategories s where s.supCateName = :supCategoryName")
	SupCategories findSupCategoryBySupCategoryName(String supCategoryName);
}
