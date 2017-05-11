package com.allianzafrica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allianzafrica.model.Department;
import com.allianzafrica.service.GroupService;
import com.allianzafrica.service.EmployeeService;

@Controller
@RequestMapping("/departements")
public class DepartmentController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	GroupService departmentService;
	
	
	@ModelAttribute("dept")
	protected Department initDepartment(){
		return new Department();
	}
	
	@ModelAttribute("departements")
	protected List<Department> listDepartements(){
		return departmentService.findAll();
	}
	
	@GetMapping()
	public String departements(Model model ){
		List<Department> departements;
		departements = departmentService.findAll(new Sort(Direction.ASC,"name"));
		model.addAttribute("departements",departements);
		return "departments";
	}
	
	
	@GetMapping("/new")
	public String nouveauDepartement(Model model){
		Department dept = new Department();
		model.addAttribute(dept);
		return "editdepartment";
	}
	
	@GetMapping("/add")
	public String creerDepartement(Model model){
		Department dept = new Department();
		model.addAttribute("dept", dept);
		return "departments";
	}
	
	
	@PostMapping(value = {"/add", "/save"})
	public String enregistrerDepartement(@Valid @ModelAttribute("dept") Department dept, BindingResult result){
		if (result.hasErrors()){
			return "editdepartment";
		} 
		departmentService.save(dept);
		return "redirect:/departements";
	}
	
	@GetMapping("/edit/{department}")
	public String editerDepartement(Department department, Model model){
		return "editdepartment"; 
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteDepartement(@PathVariable("id") Long id){
		departmentService.delete(id);
		return "redirect:/departements";
	}

}
