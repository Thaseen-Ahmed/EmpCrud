package com.thaseen.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thaseen.crud.Model.Employee;
import com.thaseen.crud.Service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {

	@Autowired
	EmpService empserv;
	
	@GetMapping("/")
//	To display All Emp
	public String Homepage(Model model) {
		
		model.addAttribute("listEmp", empserv.getAllEmployees());
		return "index";
	}
//	@GetMapping("/")
//	public String Homepage(Model model) {
//		return findPaginted(1, model);
//		
//	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee,HttpSession session) {
//		save emp to db
		empserv.saveEmployee(employee);
		return "redirect:/";
		
	}
		
	@GetMapping("/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable(value = "id") long id, Model mo){
//		Getting Emp from Service
		Employee employee = empserv.getEmployeeById(id);
		
//		setting Employee as a model to show in form
		mo.addAttribute("employee", employee);
		return "update_Employee";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") long id ) {
		
		this.empserv.deleteEmployeeById(id);
		
		return "redirect:/";	
	}
		
//	Pagination Concept
	
//	@GetMapping("/page/{pageNo}")
//	public String findPaginted(@PathVariable (value = "pageNo") int pageNo,Model model) {
//		int pageSize = 5;
//		
//		Page<Employee> page = empserv.findPaginated(pageNo, pageSize);
//		List<Employee> listEmp = page.getContent();
//		
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		model.addAttribute("listEmployees", listEmp);
//		
//		return "index";
//	}
		
		
	}
	
