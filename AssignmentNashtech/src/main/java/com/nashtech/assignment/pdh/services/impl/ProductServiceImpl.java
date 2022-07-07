package com.nashtech.assignment.pdh.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nashtech.assignment.pdh.dto.ProductDTO;
import com.nashtech.assignment.pdh.entities.Categories;
import com.nashtech.assignment.pdh.entities.Products;
import com.nashtech.assignment.pdh.entities.SupCategories;
import com.nashtech.assignment.pdh.exception.ResourceNotFoundException;
import com.nashtech.assignment.pdh.repositories.CategoryRepository;
import com.nashtech.assignment.pdh.repositories.ProductRepository;
import com.nashtech.assignment.pdh.repositories.SupCategoryRepository;
import com.nashtech.assignment.pdh.response.MessageResponse;
import com.nashtech.assignment.pdh.services.ICategoryService;
import com.nashtech.assignment.pdh.services.IProductService;
import com.nashtech.assignment.pdh.services.ISupCategoryService;

@Component
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SupCategoryRepository supCategoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> addProduct(ProductDTO productDTO) {
		Optional<Categories> categoryOptional = categoryRepository.findById(productDTO.getCategories().getCategoryId());
		Optional<SupCategories> supCategoryOptional = supCategoryRepository
				.findById(productDTO.getSupCategories().getSupCateId());

		if (!categoryOptional.isPresent() && !supCategoryOptional.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Category not found"));
		}

		productRepository.save(modelMapper.map(productDTO, Products.class));
		return ResponseEntity.ok(new MessageResponse("Add new Product successfully"));
	}

	@Override
	public ResponseEntity<?> updateProduct(long id, ProductDTO productDTO) throws ResourceNotFoundException {
		Optional<Products> optionalProduct = productRepository.findById(id);
		if (!optionalProduct.isPresent()) {
			throw new ResourceNotFoundException("Product not found");
		}
		Optional<Categories> categoryOptional = categoryRepository.findById(productDTO.getCategories().getCategoryId());
		Optional<SupCategories> supCategoryOptional = supCategoryRepository
				.findById(productDTO.getSupCategories().getSupCateId());
		if (!categoryOptional.isPresent() && !supCategoryOptional.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Category not found"));
		}

		Products product = optionalProduct.get();

		modelMapper.map(productDTO, product);
		product = productRepository.save(product);
		return ResponseEntity.ok(new MessageResponse("Update Product successfully"));

	}

	@Override
	public ResponseEntity<?> deleteProduct(long id) throws ResourceNotFoundException {
		Optional<Products> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Products product = optional.get();
			productRepository.delete(product);
			return ResponseEntity.ok(new MessageResponse("The book deleted successfully"));
		}
		throw new ResourceNotFoundException("Product is not found");
	}

	@Override
	public ResponseEntity<?> getAllProduct() {
		List<Products> list = productRepository.findAll();
		List<ProductDTO> dto = new ArrayList<ProductDTO>();
		list.forEach(b -> dto.add(modelMapper.map(b, ProductDTO.class)));
		return ResponseEntity.ok(dto);
	}

	@Override
	public List<ProductDTO> getAllProductbyCategory(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> getAllProductbySupCategory(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO findByIdProduct(long id) throws ResourceNotFoundException {
		Optional<Products> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Products product = optional.get();
			return modelMapper.map(product, ProductDTO.class);
		}
		throw new ResourceNotFoundException("Product not found");
	}

}
