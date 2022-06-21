package com.nashtech.assignment.pdh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.FeedBack;
import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.repositories.CategoryRepository;
import com.nashtech.assignment.pdh.repositories.FeedBackRepository;
import com.nashtech.assignment.pdh.repositories.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductTest {
	
	@Autowired
	private CategoryRepository CateRe;
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private FeedBackRepository backRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void TestProduct() {
		
//		Categories cate = new Categories();
//		cate.setCategoryName("test2");
//		
//		CateRe.save(cate);
		
		FeedBack fBack = new FeedBack();
		fBack.setFbComment("test");
		
		backRepository.save(fBack);
		
		
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
