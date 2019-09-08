package com.trantrongnhan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="building")
public class BuildingEntity extends AbstractEntity{
	@Column(name="name")
	private String name;
	
	@Column(name="ward")
	private String ward;

	@Column(name="structure")
	private String structure;
	
	@Column(name="street")
	private String street;
	
	@Column(name="rentarea")
	private String rentArea;
	
	@Column(name="district")
	private String district;

	@Column(name="managename")
	private String manageName;
	
	@Column(name="managephone")
	private String managePhone;

	@Column(name="direction")
	private String direction;
	
	@Column(name="areadescription")
	private String areaDescription;
	
	@Column(name="costdescription")
	private String costDescription;
	
	@Column(name="servicecost")
	private String serviceCost;

	@Column(name="motorbikecost")
	private String motorbikeCost;

	@Column(name="carcost")
	private String carCost;
	
	@Column(name="overtimecost")
	private String overtimeCost;
	
	@Column(name="electricitycost")
	private String electricityCost;

	@Column(name="deposit")
	private String deposit;
	
	@Column(name="payment")
	private String payment;
	
	@Column(name="rentperiod")
	private String rentPeriod;
	
	@Column(name="numberofbasement")
	private Integer numberOfBasement;
	
	@Column(name="buildingarea",nullable=true)
	private Integer buildingArea;

	@Column(name="level")
	private Integer level;
	
	@Column(name="rentcost")
	private Integer rentCost;
	
	@Column(name="type")
	private String type;
	@OneToMany(mappedBy="building")
	private List<RentAreaEntity>rentAreas=new ArrayList<RentAreaEntity>();

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

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRentArea() {
		return rentArea;
	}

	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getManageName() {
		return manageName;
	}

	public void setManageName(String manageName) {
		this.manageName = manageName;
	}

	public String getManagePhone() {
		return managePhone;
	}

	public void setManagePhone(String managePhone) {
		this.managePhone = managePhone;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

	public String getCostDescription() {
		return costDescription;
	}

	public void setCostDescription(String costDescription) {
		this.costDescription = costDescription;
	}

	public String getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(String serviceCost) {
		this.serviceCost = serviceCost;
	}

	public String getMotorbikeCost() {
		return motorbikeCost;
	}

	public void setMotorbikeCost(String motorbikeCost) {
		this.motorbikeCost = motorbikeCost;
	}

	public String getCarCost() {
		return carCost;
	}

	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}

	public String getOvertimeCost() {
		return overtimeCost;
	}

	public void setOvertimeCost(String overtimeCost) {
		this.overtimeCost = overtimeCost;
	}

	public String getElectricityCost() {
		return electricityCost;
	}

	public void setElectricityCost(String electricityCost) {
		this.electricityCost = electricityCost;
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

	public String getRentPeriod() {
		return rentPeriod;
	}

	public void setRentPeriod(String rentPeriod) {
		this.rentPeriod = rentPeriod;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Integer getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Integer buildingArea) {
		this.buildingArea = buildingArea;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getRentCost() {
		return rentCost;
	}

	public void setRentCost(Integer rentCost) {
		this.rentCost = rentCost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<RentAreaEntity> getRentAreas() {
		return rentAreas;
	}

	public void setRentAreas(List<RentAreaEntity> rentAreas) {
		this.rentAreas = rentAreas;
	}
	

}
