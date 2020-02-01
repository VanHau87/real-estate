package com.laptrinhweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.entity.BuildingEntity;

public class BuildingConverter {
	private ModelMapper modelMapper = new ModelMapper();
	
	public BuildingEntity dto2Entity(BuildingDTO dto) {
		return modelMapper.map(dto, BuildingEntity.class);
	}
	
	public BuildingDTO entity2DTO(BuildingEntity entity) {
		return modelMapper.map(entity, BuildingDTO.class);
	}
}
