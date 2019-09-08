package com.trantrongnhan.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trantrongnhan.builder.BuildingBuilder;
import com.trantrongnhan.dto.BuildingDTO;
import com.trantrongnhan.entity.BuildingEntity;
import com.trantrongnhan.repository.BuildingRepository;
import com.trantrongnhan.service.IBuildingService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BuildingAPI {
	@Autowired
	private IBuildingService buildingService;
	@Autowired
	private BuildingRepository buildingRepository;

	@RequestMapping(value = { "/api/admin/building" }, method = RequestMethod.POST)
	public BuildingDTO saveBuilding(@RequestBody BuildingDTO buildingDTO) {
		System.out.println("dfdfdsf");
		return buildingService.save(buildingDTO);
	}

	@GetMapping(value = { "/api/admin/building" })
	public List<BuildingEntity> searchBuilding(@RequestParam Map<String, Object> params) {
		System.out.println("vào nha");
		// List<BuildingEntity>buildings=buildingRepository.findByTypeContaining("TANG_TRET");
		BuildingBuilder builder = innitBuildingBuilder(params);
		List<BuildingEntity>buildings=buildingRepository.search(builder);
		return buildings;

	}

	public BuildingBuilder innitBuildingBuilder(Map<String, Object> params) {
		BuildingBuilder.Builder builder = new BuildingBuilder.Builder();
		Class clazz = builder.getClass();
		try {
			for (Entry<String, Object> i : params.entrySet()) {
				Field field = clazz.getDeclaredField(i.getKey());
				
				if (field.getType().equals(Integer.class)) {
					Method method = clazz.getMethod("set" + StringUtils.capitalize(field.getName()),Integer.class);
					method.invoke(builder, Integer.valueOf((String) i.getValue()));
				}
				if (field.getType().equals(String.class)) {
					Method method = clazz.getMethod("set" + StringUtils.capitalize(field.getName()),String.class);
					method.invoke(builder, (String) i.getValue());
				}
				/*if (field.getType().equals(String[].class)) {
					Method method = clazz.getMethod("set" + StringUtils.capitalize(field.getName()),String[].class);
					Parameter[] pr=method.getParameters();
					String[] arr=i.getValue().toString().split(",");
					method.invoke(builder,(Object[])arr);
					
				}*/
			}
		} catch (NoSuchFieldException | SecurityException | NoSuchMethodException | IllegalArgumentException
				| IllegalAccessException | InvocationTargetException e) {

			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(params.get("buildingTypes"));
		if(params.get("buildingTypes")!=null)
			builder.setBuildingTypes(params.get("buildingTypes").toString().split(","));
		return builder.build();

	}
}
