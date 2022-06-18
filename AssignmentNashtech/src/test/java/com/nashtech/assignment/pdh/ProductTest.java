package com.nashtech.assignment.pdh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.repositories.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductTest {
	
	@Autowired
	private ProductRepository repository;
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void TestProduct() {
		Products products = new Products();
		products.setProName("Test");
		products.setProPice(50);
		products.setProImage("Test");
		products.setProDiscreption("test");
		products.setProQuantity(50);
		
		Products saveProducts = repository.save(products);
		
		Products exitProducts = entityManager.find(Products.class, saveProducts.getProId());
		
		assertThat(exitProducts.getProName()).isEqualTo(products.getProName());
				
	}
}
