package com.laptrinhweb.enums;

public enum BuidingTypeEnums {
	
	TRANG_TRET("Trầng trệt"),
	NGUYEN_CAN("Nguyên căn"),
	NOI_THAT("Nội thất");
	
	private final String value;
	
	private BuidingTypeEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
