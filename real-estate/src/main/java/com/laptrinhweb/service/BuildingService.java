package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.dto.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(BuildingSearchBuilder builder);
}
