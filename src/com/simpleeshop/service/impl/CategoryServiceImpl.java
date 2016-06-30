package com.simpleeshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleeshop.entity.Category;
import com.simpleeshop.repository.CategoryRepository;
import com.simpleeshop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void add() {
		categoryRepository.saveAndFlush(new Category());
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	@Override
	public void update(Category category) {
		categoryRepository.update(category.getId(), category.getName());
	}
}
