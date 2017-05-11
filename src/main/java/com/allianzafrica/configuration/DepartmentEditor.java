package com.allianzafrica.configuration;

import java.beans.PropertyEditorSupport;

import com.allianzafrica.model.Department;
import com.allianzafrica.service.GroupService;

public class DepartmentEditor extends PropertyEditorSupport {
	GroupService deptService;
	
	public DepartmentEditor(GroupService departmentService){
		this.deptService = departmentService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Department dept = deptService.findOne(Long.parseLong(text));
		setValue(dept);
	}

}
