package com.laptrinhweb;

import java.util.List;

import com.laptrinhweb.builder.BuildingSearchBuilder;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.service.BuildingService;
import com.laptrinhweb.service.impl.BuildingServiceImpl;

public class RealEstateApplication {
	
	public static void main(String[] args) {
		String name = "tower";
		String district = "QUAN_1";
//		String[] types = new String[] {"TANG_TRET", "NGUYEN_CAN"};
		String numberOfBasement = "2";
		String floorArea = "500";
		
		BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
				.setName(name).setDistrict(district)
				.setNumberOfBasement(numberOfBasement).setFloorArea(floorArea).build();
		
		BuildingService buildingService = new BuildingServiceImpl();
		List<BuildingDTO> results = buildingService.findAll(builder); 
		
	}
}
