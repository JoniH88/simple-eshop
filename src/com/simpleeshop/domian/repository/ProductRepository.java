package com.simpleeshop.domian.repository;

import java.util.List;
import com.simpleeshop.domian.Product;

public interface ProductRepository {
	List<Product> getAllProducts();

	Product getProductById(String productID);

	List<Product> getProductsByCategory(String category);

	void addProduct(Product product);
}
