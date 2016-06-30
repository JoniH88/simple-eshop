package com.simpleeshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleeshop.entity.Product;
import com.simpleeshop.repository.ProductRepository;
import com.simpleeshop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public Product getProductById(Long id) {
		return productRepository.getOne(id);
	}
	
	@Override
	public void addProduct(Product product) {
		productRepository.saveAndFlush(product);
	}
}
