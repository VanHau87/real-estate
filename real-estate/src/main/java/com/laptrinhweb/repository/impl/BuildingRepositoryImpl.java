package com.laptrinhweb.repository.impl;

import java.util.List;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.entity.BuildingEntity;
import com.laptrinhweb.repository.BuildingRepository;

public class BuildingRepositoryImpl extends JpaRepositoryImpl<BuildingEntity> implements BuildingRepository {

	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder builder) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b WHERE 1=1");
		if (builder.getName() != null) {
			sql.append(" AND b.name LIKE '%" + builder.getName() + "%'");
		}
		if (builder.getDistrict() != null) {
			sql.append(" AND b.district LIKE '%" + builder.getDistrict() + "%'");
		}
		if (builder.getNumberOfBasement() != null) {
			sql.append(" AND b.number_of_basement =" + builder.getNumberOfBasement() + "");
		}
		if (builder.getFloorArea() != null) {
			sql.append(" AND b.floor_area =" + builder.getFloorArea() + "");
		}
		return this.findAll(sql);
	}

	
}
