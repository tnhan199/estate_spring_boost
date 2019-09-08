package com.trantrongnhan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.trantrongnhan.CustomRepository.BuildingRepositoryCustom;
import com.trantrongnhan.builder.BuildingBuilder;
import com.trantrongnhan.entity.BuildingEntity;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Integer>,JpaSpecificationExecutor<BuildingEntity>,BuildingRepositoryCustom{
	List<BuildingEntity>findByTypeContaining(String s);
	//List<BuildingEntity>search(Specification<BuildingEntity>spec);
	List<BuildingEntity> search(BuildingBuilder buildingBuilder);
}
