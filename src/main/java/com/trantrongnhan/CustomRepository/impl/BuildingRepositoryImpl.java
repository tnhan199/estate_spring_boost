package com.trantrongnhan.CustomRepository.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.trantrongnhan.CustomRepository.BuildingRepositoryCustom;
import com.trantrongnhan.builder.BuildingBuilder;
import com.trantrongnhan.entity.BuildingEntity;
@Transactional
@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	public StringBuilder buildWhereClause(BuildingBuilder builder) {
		StringBuilder result = new StringBuilder("");
		if (builder.getRentCostFrom() != null) {
			result.append(" and rentcost >= " + builder.getRentCostFrom().toString());
		}
		if (builder.getRentCostTo() != null) {
			result.append(" and rentcost <= " + builder.getRentAreaTo().toString());
		}
		if (builder.getRentAreaFrom() != null || builder.getRentAreaTo() != null) {
			result.append(" and exists (select * from rentarea b where a.id=b.buildingid");
			if (builder.getRentAreaFrom() != null) {
				result.append(" and b.value >= " + builder.getRentAreaFrom().toString());
			}
			if (builder.getRentAreaTo() != null) {
				result.append(" and b.value <= " + builder.getRentAreaTo().toString());
			}
			result.append(")");
		}
		if (builder.getBuildingTypes() != null && builder.getBuildingTypes().length > 0) {
			result.append(" and (" + "type like " + "'%" + builder.getBuildingTypes()[0] + "%'");
			for (int i = 1; i < builder.getBuildingTypes().length; i++) {
				result.append(" or type like " + "'%" + builder.getBuildingTypes()[i] + "%'");
			}
			result.append(")");
		}
		return result;
	}

	@Override
	public List<BuildingEntity> search(BuildingBuilder builder) {
		StringBuilder sql = new StringBuilder("select * from building a where 1=1");
		System.out.println(builder.getClass());
		Field[] fields = builder.getClass().getDeclaredFields();
		for (Field i : fields) {
			i.setAccessible(true);
			if (i.getName().contains("rentArea") || i.getName().contains("rentCost")
					|| i.getName().equals("buildingTypes")) {
				continue;
			} else {
				try {
					if (i.get(builder) != null) {
						sql.append(" and " + i.getName().toLowerCase());
						if (i.getType().equals(String.class) && i.get(builder) != null)
							sql.append(" like '" + i.get(builder)+"'");
						if (i.getType().equals(Integer.class) && i.get(builder) != null)
							sql.append(" = " + i.get(builder).toString());
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		StringBuilder where = buildWhereClause(builder);
		if (!where.equals(""))
			sql.append(where);
		System.out.println(sql.toString());
		@SuppressWarnings("unchecked")
		List<BuildingEntity> result = em.createNativeQuery(sql.toString(), BuildingEntity.class).getResultList();
		return result;
	}

}
