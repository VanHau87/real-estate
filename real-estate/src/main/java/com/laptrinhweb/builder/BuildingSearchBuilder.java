package com.laptrinhweb.builder;

public class BuildingSearchBuilder {
	private String name;
	private String district;
	private String numberOfBasement;
	private String floorArea;
	
	private BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.district = builder.district;
		this.numberOfBasement = builder.numberOfBasement;
		this.floorArea = builder.floorArea;
	}
	public String getName() {
		return name;
	}


	public String getDistrict() {
		return district;
	}


	public String getNumberOfBasement() {
		return numberOfBasement;
	}


	public String getFloorArea() {
		return floorArea;
	}


	public static class Builder{
		private String name;
		private String district;
		private String numberOfBasement;
		private String floorArea;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setDistrict(String district) {
			this.district = district;
			return this;
		}
		public Builder setNumberOfBasement(String numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}
		
		public Builder setFloorArea(String floorArea) {
			this.floorArea = floorArea;
			return this;
		}
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
	}
}
