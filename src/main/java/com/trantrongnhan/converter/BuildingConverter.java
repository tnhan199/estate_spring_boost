package com.trantrongnhan.converter;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.trantrongnhan.Enum.District;
import com.trantrongnhan.dto.BuildingDTO;
import com.trantrongnhan.entity.BuildingEntity;

@Component
public class BuildingConverter {
	public BuildingEntity toEntity(BuildingDTO buildingDTO) {
		ModelMapper modelMapper=new ModelMapper();
		BuildingEntity buildingEntity=modelMapper.map(buildingDTO, BuildingEntity.class);
		if(buildingDTO.getBuildingTypes()!=null && buildingDTO.getBuildingTypes().length>0) {
			String type=StringUtils.join(buildingDTO.getBuildingTypes(),",");
			buildingEntity.setType(type);
		}
		return buildingEntity;
		
	}
	public BuildingDTO toDTO(BuildingEntity buildingEntity) {
		ModelMapper modelMapper=new ModelMapper();
		BuildingDTO buildingDTO=modelMapper.map(buildingEntity,BuildingDTO.class);
		String location="";
		if(buildingEntity.getStreet()!=null) {
			location+=buildingEntity.getStreet();
		}
		if(buildingEntity.getWard()!=null) {
			location+=buildingEntity.getWard();
		}
		if(StringUtils.isNotBlank(buildingEntity.getDistrict())) {
			location+=District.valueOf(buildingEntity.getDistrict()).getDistrict();
		}
		buildingDTO.setLocation(location);
		return buildingDTO;
	}
}
