package com.simpleeshop.service;

import java.util.List;

import com.simpleeshop.entity.Product;


public interface ProductService {
	List<Product> getAllProducts();
	
	Product getProductById(Long id);
	
	//List<Product> getProductsByCategory(String category);
	
	void addProduct(Product product);
}
