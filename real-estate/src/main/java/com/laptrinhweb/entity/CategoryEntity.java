package com.laptrinhweb.entity;

import java.sql.Timestamp;

import com.laptrinhweb.annotation.Column;
import com.laptrinhweb.annotation.Entity;
import com.laptrinhweb.annotation.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@Column(name = "createddate")
	private Timestamp createdDate;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
}
