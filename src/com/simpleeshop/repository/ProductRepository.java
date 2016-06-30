package com.simpleeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpleeshop.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
