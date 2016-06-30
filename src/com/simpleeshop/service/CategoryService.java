package com.simpleeshop.service;

import java.util.List;

import com.simpleeshop.entity.Category;

public interface CategoryService {
	List<Category> getAll();
	
	void add();
	
	void delete(Long id);
	
	void update(Category category);
}
