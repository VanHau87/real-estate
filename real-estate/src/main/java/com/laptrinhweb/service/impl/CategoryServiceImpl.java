package com.laptrinhweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.converter.CategoryConverter;
import com.laptrinhweb.dto.CategoryDTO;
import com.laptrinhweb.entity.CategoryEntity;
import com.laptrinhweb.repository.CategoryRepository;
import com.laptrinhweb.repository.impl.CategoryReposioryImpl;
import com.laptrinhweb.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	private CategoryRepository categoryRepository = new CategoryReposioryImpl();
	private CategoryConverter categoryConverter = new CategoryConverter();

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> categories = categoryRepository.findAll();
		List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		for (CategoryEntity entity : categories) {
			CategoryDTO dto = categoryConverter.entity2DTO(entity);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void insert(CategoryDTO dto) {
		CategoryEntity entity = categoryConverter.dto2Entity(dto);
		categoryRepository.save(entity);
	}

}
