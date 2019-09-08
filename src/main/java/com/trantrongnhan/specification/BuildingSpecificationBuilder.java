package com.trantrongnhan.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;

public class BuildingSpecificationBuilder {
	List<SearchCriteria> searchCriterias;
	public BuildingSpecificationBuilder() {
		this.searchCriterias=new ArrayList<SearchCriteria>();
	}
	public void with(SearchCriteria searchCriteria) {
		this.searchCriterias.add(searchCriteria);
	}
	public BuildingSpecification build() {
		if(searchCriterias.size()==0)
			return null;
		List<BuildingSpecification> specs=searchCriterias.stream().map(i->{return new BuildingSpecification(i);}).collect(Collectors.toList());
		System.out.println(specs.size());
		BuildingSpecification result=specs.get(0);
		for(int i=1;i<specs.size();i++) {
			result=(BuildingSpecification) Specification.where(result).and(specs.get(i));
		}
		return result;
	}
}
