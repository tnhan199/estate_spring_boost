package com.trantrongnhan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trantrongnhan.converter.BuildingConverter;
import com.trantrongnhan.dto.BuildingDTO;
import com.trantrongnhan.entity.BuildingEntity;
import com.trantrongnhan.entity.RentAreaEntity;
import com.trantrongnhan.repository.BuildingRepository;
import com.trantrongnhan.repository.RentAreaRepository;
import com.trantrongnhan.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private RentAreaRepository rentAreaRepository;

	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity=buildingRepository.save(buildingConverter.toEntity(buildingDTO));
		String arr[]=StringUtils.split(buildingDTO.getRentArea(),",");
		for(String i : arr) {
			RentAreaEntity rentAreaEntity=new RentAreaEntity();
			rentAreaEntity.setValue(Integer.valueOf(i));
			rentAreaEntity.setBuilding(buildingEntity);
			rentAreaRepository.save(rentAreaEntity);
		}
		return buildingDTO;
	}

	@Override
	public Page<BuildingDTO> findAll(Pageable pageable) {
		
		Page<BuildingEntity> prePage=buildingRepository.findAll(PageRequest.of(0,4));
		List<BuildingDTO> buildingDTOs=prePage.getContent().stream().map(i->buildingConverter.toDTO(i)).collect(Collectors.toList());
		Page<BuildingDTO> result=new PageImpl<BuildingDTO>(buildingDTOs,prePage.getPageable(),prePage.getTotalPages());
		return result;
	}
	
}
