package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.dto.Employee;
import com.mvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", employeeService.listEmployees());
		return "person";
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("employee") Employee e) {
		if (e.getId() == 0) {
			employeeService.addEmployee(e);
		} else {
			employeeService.updateEmployee(e);
		}
		return "redirect:/employees";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("listEmployees", employeeService.listEmployees());
		return "person";
	}
}
