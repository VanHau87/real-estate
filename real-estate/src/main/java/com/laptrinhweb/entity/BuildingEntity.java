package com.laptrinhweb.entity;

import java.sql.Timestamp;

import com.laptrinhweb.annotation.Column;
import com.laptrinhweb.annotation.Entity;
import com.laptrinhweb.annotation.Table;

@Entity
@Table(name = "building")
public class BuildingEntity {
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "ward")
	private String ward;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "structure")
	private String structure;
	
	@Column(name = "number_of_basement")
	private Integer numberOfBasement;
	
	@Column(name = "floor_area")
	private Integer floorarea;
	
	@Column(name = "direction")
	private String direction;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "area_description")
	private String areaDescription;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "rental")
	private Integer rental;
	
	@Column(name = "rental_description")
	private String rentalDescription;
	
	@Column(name = "service_charge")
	private String serviceCharge;
	
	@Column(name = "car_cost")
	private String carCost;
	
	@Column(name = "motor_cost")
	private String motorCost;
	
	@Column(name = "ot_Cost")
	private String otCost;
	
	@Column(name = "types")
	private String types;
	
	@Column(name = "electric_bill")
	private String electricBill;

	@Column(name = "deposit")
	private String deposit;

	@Column(name = "payment")
	private String payment;

	@Column(name = "time_rent")
	private String timeRent;

	@Column(name = "time_decoration")
	private String timeDecoration;

	@Column(name = "management")
	private String management;

	@Column(name = "management_phone")
	private String managementPhone;
	
	@Column(name = "createddate")
	private Timestamp createdDate;
	
	@Column(name = "modifieddate")
	private Timestamp modifiedDate;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@Column(name = "modifiedby")
	private String modifiedBy;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Integer getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getRental() {
		return rental;
	}

	public void setRental(Integer rental) {
		this.rental = rental;
	}

	public String getRentalDescription() {
		return rentalDescription;
	}

	public void setRentalDescription(String rentalDescription) {
		this.rentalDescription = rentalDescription;
	}

	public String getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(String serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getCarCost() {
		return carCost;
	}

	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}

	public String getMotorCost() {
		return motorCost;
	}

	public void setMotorCost(String motorCost) {
		this.motorCost = motorCost;
	}

	public String getOtCost() {
		return otCost;
	}

	public void setOtCost(String otCost) {
		this.otCost = otCost;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getElectricBill() {
		return electricBill;
	}

	public void setElectricBill(String electricBill) {
		this.electricBill = electricBill;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getTimeRent() {
		return timeRent;
	}

	public void setTimeRent(String timeRent) {
		this.timeRent = timeRent;
	}

	public String getTimeDecoration() {
		return timeDecoration;
	}

	public void setTimeDecoration(String timeDecoration) {
		this.timeDecoration = timeDecoration;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}

	public String getManagementPhone() {
		return managementPhone;
	}

	public void setManagementPhone(String managementPhone) {
		this.managementPhone = managementPhone;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
