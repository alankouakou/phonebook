package net.ycod3r.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.ycod3r.model.Department;
import net.ycod3r.service.EmployeeService;
import net.ycod3r.service.GroupService;

@Controller
@RequestMapping("/departements")
public class DepartmentController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	GroupService departmentService;
	
	private String message;
	
	
	@ModelAttribute("dept")
	protected Department initDepartment(){
		return new Department();
	}
	
	@ModelAttribute("departements")
	protected List<Department> listDepartements(){
		return departmentService.findAll();
	}
	
	@GetMapping()
	public String departements(Model model, @ModelAttribute("message") String message ){
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
	public String enregistrerDepartement(@Valid @ModelAttribute("dept") Department dept, BindingResult result, RedirectAttributes ra){
		if (result.hasErrors()){
			return "editdepartment";
		} 
		message = "Département " + dept.getName() + " ajouté avec succès!";
		ra.addFlashAttribute("message", message);
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
