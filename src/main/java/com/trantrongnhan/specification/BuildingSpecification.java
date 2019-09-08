package com.trantrongnhan.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.trantrongnhan.entity.BuildingEntity;

public class BuildingSpecification implements Specification<BuildingEntity>{
	private SearchCriteria searchCriteria;
	public BuildingSpecification() {
		
	}
	public BuildingSpecification(SearchCriteria searchCriteria) {
		this.searchCriteria=searchCriteria;
	}
	public Predicate toPredicate(Root<BuildingEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if(searchCriteria.getOperation().equalsIgnoreCase(">=")) 
			return criteriaBuilder.ge(root.get(searchCriteria.getKey()), (Number)searchCriteria.getValue());	
		if(searchCriteria.getOperation().equalsIgnoreCase("<="))
			return criteriaBuilder.le(root.get(searchCriteria.getKey()), (Number)searchCriteria.getValue());
		if(searchCriteria.getOperation().equalsIgnoreCase("<"))
			return criteriaBuilder.lt(root.get(searchCriteria.getKey()), (Number)searchCriteria.getValue());
		if(searchCriteria.getOperation().equalsIgnoreCase(">"))
			return criteriaBuilder.gt(root.get(searchCriteria.getKey()), (Number)searchCriteria.getValue());
		if(searchCriteria.getOperation().equalsIgnoreCase(":")) {
			if(root.get(searchCriteria.getKey()).getJavaType().equals(String.class))
				return criteriaBuilder.like(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
			else
				return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
		}
		return null;
	}

}
