package com.nashtech.assignment.pdh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nashtech.assignment.pdh.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
	@Query("SELECT p FROM Products p where categoryId = :id")
	List<Products> getProductbyIdcategory(Long id);

//	@Query("Select p FROM Products p Where p.proName =:productName")
//	List<Products> findByProductName(String productName);

	@Query("SELECT p FROM Products p where p.proId = :id")
	Products findByIdProduct(Long id);

}
