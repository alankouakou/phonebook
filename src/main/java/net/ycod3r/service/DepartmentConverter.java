package net.ycod3r.service;

import org.springframework.core.convert.converter.Converter;

import net.ycod3r.model.Department;

public final class DepartmentConverter implements Converter<String, Department>{
	
	private final GroupService departmentService;
	
	public DepartmentConverter(GroupService departmentService) {
		this.departmentService = departmentService;
	}



	@Override
	public Department convert(String id) {
		
		if(id == null ||id.isEmpty()){
			return null;
		}
		Department department = departmentService.findOne(Long.parseLong(id));
		return department;
	}

}
