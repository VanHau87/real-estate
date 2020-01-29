package com.laptrinhweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhweb.dto.NewsDTO;
import com.laptrinhweb.entity.NewsEntity;

public class NewsConverter {
	private ModelMapper modelMapper = new ModelMapper();
	
	public NewsEntity dto2Entity(NewsDTO dto) {
		return modelMapper.map(dto, NewsEntity.class);
	}
	
	public NewsDTO entity2DTO(NewsEntity entity) {
		return modelMapper.map(entity, NewsDTO.class);
	}
}
