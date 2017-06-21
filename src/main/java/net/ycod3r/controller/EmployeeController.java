package net.ycod3r.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.ycod3r.configuration.DepartmentEditor;
import net.ycod3r.model.Department;
import net.ycod3r.model.Employee;
import net.ycod3r.service.EmployeeService;
import net.ycod3r.service.GroupService;

@Controller
@RequestMapping({"/"})
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	GroupService departmentService;

	private String message;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder){
		binder.registerCustomEditor(Department.class, new DepartmentEditor(departmentService));
	}
	
	@ModelAttribute("employee1")
	protected Employee initEmployee(){
		return new Employee();
	}
	
	@ModelAttribute("departements")	
	protected List<Department> listDepartements(){
		return departmentService.findAll();
	}
	
	@GetMapping("/employees")
	public String employees(Model model ){
		List<Employee> employees;
		employees = empService.findAll(new Sort(Direction.ASC,"nom"));
		model.addAttribute("employees",employees);
		return "index";
	}
	
	@GetMapping()
	public String dashboard(Model model, @ModelAttribute("message") String message){
		List<Employee> employees;
		Long totalEmployees, totalDepartments;
		
		employees = empService.findAll();
		totalEmployees = empService.count();
		totalDepartments = departmentService.count();
		model.addAttribute("employees",employees);
		model.addAttribute("totalEmployees",totalEmployees);
		model.addAttribute("totalDepartments",totalDepartments);
		System.out.println("Total employes: " + totalEmployees);
		return "dashboard";
	}
	
	@GetMapping("employees/add")
	public String creerEmploye(Model model){
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "index";
	}
	
	
	@PostMapping(value = {"employees/add", "employees/save"})
	public String enregistrerEmploye(@Valid @ModelAttribute("employee1") Employee emp, BindingResult bindingResult, RedirectAttributes ra){
		if(bindingResult.hasErrors()){
			return "editemployee";
		}
		message = emp.getPrenom() + " "+emp.getNom()+" ajouté avec succès!";
		ra.addFlashAttribute("message", message );
		empService.save(emp);
		return "redirect:/employees";
	}
/*	
	@GetMapping("/employees/edit/{id}")
	public String editerEmployee(@PathVariable("id") Long id, Model model){
		Employee employee=empService.findOne(id);
		model.addAttribute("employee", employee);
		return "editemployee"; 
	}
*/
	@GetMapping("employees/edit/{employee}")
	public String editerEmployee(Employee employee, Model model){
		return "editemployee"; 
	}
	
	
	@PostMapping("employees/edit")
	public String sauverModifsEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
		if (bindingResult.hasErrors()){
			return "editemployee";
		}
		empService.save(employee);
		return "redirect:/employees"; 
	}

	@GetMapping("employees/delete/{id}")
	public String supprimerEmployee(@PathVariable("id") Long id) throws Exception {
		if (id < 33)
			throw new NullPointerException("Suppression non autorisée!");
		empService.delete(id);
		return "redirect:/employees";
		
	}

	@GetMapping("employees/test")
	public String testMethod(Model model ){
		List<Employee> employees;
		employees = empService.findAll(new Sort(Direction.ASC,"nom"));
		model.addAttribute("employees",employees);
		return "index2";
	}
	
	

}
