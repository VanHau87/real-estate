package com.laptrinhweb.repository;

import java.util.List;

import com.laptrinhweb.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity>{
	List<CategoryEntity> findAll();
	void save(CategoryEntity entity);
}
