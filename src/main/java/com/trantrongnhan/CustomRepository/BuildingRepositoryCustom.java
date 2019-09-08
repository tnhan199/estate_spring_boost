package com.trantrongnhan.CustomRepository;

import java.util.List;

import com.trantrongnhan.builder.BuildingBuilder;
import com.trantrongnhan.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity>search(BuildingBuilder builder);
}
