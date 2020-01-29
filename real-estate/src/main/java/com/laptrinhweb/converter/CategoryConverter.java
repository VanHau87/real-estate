package com.laptrinhweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhweb.dto.CategoryDTO;
import com.laptrinhweb.entity.CategoryEntity;

public class CategoryConverter {
	private ModelMapper modelMapper = new ModelMapper();
	
	public CategoryEntity dto2Entity(CategoryDTO dto) {
		return modelMapper.map(dto, CategoryEntity.class);
	}
	public CategoryDTO entity2DTO(CategoryEntity entity) {
		return modelMapper.map(entity, CategoryDTO.class);
	}
}
