package com.simpleeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.simpleeshop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Modifying
	@Transactional
	@Query("UPDATE Category SET name=:name WHERE id=:id")
	void update(@Param("id") Long id, @Param("name") String name);
}
