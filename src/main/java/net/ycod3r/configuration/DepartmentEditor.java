package net.ycod3r.configuration;

import java.beans.PropertyEditorSupport;

import net.ycod3r.model.Department;
import net.ycod3r.service.GroupService;

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
