package com.laptrinhweb.repository;

import java.util.List;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity>{
	List<BuildingEntity> findAll(BuildingSearchBuilder builder);
}
