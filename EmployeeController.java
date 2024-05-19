package com.example.StudentCrudOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

	@Autowired 
	EmployeeService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("emp", service.getAllEmployees());
		return "index"; 
	}
	
@GetMapping("/addNewEmployee")
public String createNewEmployeePage(Model model)
{
	Employee emp=new Employee();
	model.addAttribute("emp", emp);
	return "new_employee";
}

@PostMapping("/saveEmployee")
public String saveEmployee(@ModelAttribute("emp") Employee emp)
{
	service.addEmployee(emp);
	return "redirect:/";	
}

@GetMapping("/showFormForUpdate/{id}")
public String updateEmployee(@PathVariable int id,Model model)
{
	model.addAttribute("emp", service.getEmployeeById(id));
	return "update_employee";
}

@GetMapping("/deleteEmployee/{id}")
public String deleteEmployee(@PathVariable int id)
{
	service.deleteEmployeeById(id);
	return "redirect:/";
}
}
