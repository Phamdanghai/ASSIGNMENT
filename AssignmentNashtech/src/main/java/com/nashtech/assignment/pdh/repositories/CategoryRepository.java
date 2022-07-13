package com.nashtech.assignment.pdh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {

	Categories findCategoryByCategoryName(String categoryName);
	Categories findCategoryByCategoryId(Long categoryId);

}
