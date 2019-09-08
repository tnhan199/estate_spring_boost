package com.trantrongnhan.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trantrongnhan.dto.BuildingDTO;

public interface IBuildingService {
	public BuildingDTO save(BuildingDTO buildingDTO);
	public Page<BuildingDTO> findAll(Pageable pageRequest);
}
