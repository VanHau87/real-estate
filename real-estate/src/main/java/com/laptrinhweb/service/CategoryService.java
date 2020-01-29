package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.dto.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> findAll();
	void insert(CategoryDTO dto);
}
