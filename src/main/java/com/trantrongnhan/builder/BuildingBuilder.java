package com.trantrongnhan.builder;

public class BuildingBuilder {
	private String name;
	private String district;
	private String ward;
	private Integer buildingArea;
	private String street;
	private String[] buildingTypes;
	private Integer numberOfBasement;
	private Integer rentAreaFrom;
	private Integer rentAreaTo;
	private String manageName;
	private String managePhone;
	private Integer rentCostFrom;
	private Integer rentCostTo;
	public String getName() {
		return name;
	}
	public String getDistrict() {
		return district;
	}
	public String getWard() {
		return ward;
	}
	public Integer getBuildingArea() {
		return buildingArea;
	}
	public String getStreet() {
		return street;
	}
	public String[] getBuildingTypes() {
		return buildingTypes;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public Integer getRentAreaFrom() {
		return rentAreaFrom;
	}
	public Integer getRentAreaTo() {
		return rentAreaTo;
	}
	public String getManageName() {
		return manageName;
	}
	public String getManagePhone() {
		return managePhone;
	}
	public Integer getRentCostFrom() {
		return rentCostFrom;
	}
	public Integer getRentCostTo() {
		return rentCostTo;
	}
	public BuildingBuilder(String name, String district, String ward, Integer buildingArea, String street,
			String[] buildingTypes, Integer numberOfBasement, Integer rentAreaFrom, Integer rentAreaTo,
			String manageName, String managePhone, Integer rentCostFrom, Integer rentCostTo) {
		super();
		this.name = name;
		this.district = district;
		this.ward = ward;
		this.buildingArea = buildingArea;
		this.street = street;
		this.buildingTypes = buildingTypes;
		this.numberOfBasement = numberOfBasement;
		this.rentAreaFrom = rentAreaFrom;
		this.rentAreaTo = rentAreaTo;
		this.manageName = manageName;
		this.managePhone = managePhone;
		this.rentCostFrom = rentCostFrom;
		this.rentCostTo = rentCostTo;
	}
	public static class Builder{
		private String name;
		private String district;
		private String ward;
		private Integer buildingArea;
		private String street;
		private String[] buildingTypes;
		private Integer numberOfBasement;
		private Integer rentAreaFrom;
		private Integer rentAreaTo;
		private String manageName;
		private String managePhone;
		private Integer rentCostFrom;
		private Integer rentCostTo;
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setDistrict(String district) {
			this.district = district;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setBuildingArea(Integer buildingArea) {
			this.buildingArea = buildingArea;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setBuildingTypes(String[] buildingTypes) {
			this.buildingTypes = buildingTypes;
			return this;
		}
		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}
		public Builder setRentAreaFrom(Integer rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}
		public Builder setRentAreaTo(Integer rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}
		public Builder setManageName(String manageName) {
			this.manageName = manageName;
			return this;
		}
		public Builder setManagePhone(String managePhone) {
			this.managePhone = managePhone;
			return this;
		}
		public Builder setRentCostFrom(Integer rentCostFrom) {
			this.rentCostFrom = rentCostFrom;
			return this;
		}
		public Builder setRentCostTo(Integer rentCostTo) {
			this.rentCostTo = rentCostTo;
			return this;
		}
		public BuildingBuilder build() {
			return new BuildingBuilder(name,district, ward, buildingArea, street,buildingTypes, numberOfBasement, rentAreaFrom,  rentAreaTo,
					manageName, managePhone, rentCostFrom, rentCostTo);
		}
	}
}
