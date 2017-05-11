package com.allianzafrica.service;

import org.springframework.core.convert.converter.Converter;

import com.allianzafrica.model.Employee;

public final class EmployeeConverter implements Converter<String, Employee>{

	
	private final EmployeeService empService;
	
	
	
	public EmployeeConverter(EmployeeService empService) {
		this.empService = empService;
	}


	@Override
	public Employee convert(String id) {
		// TODO Auto-generated method stub
        if (id == null || id.isEmpty()) {
            return null;
        }
        
        Employee employee = empService.findOne(Long.parseLong(id));
		return employee;
	}

}
