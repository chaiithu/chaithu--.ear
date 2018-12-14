package org.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.test.modals.Employee;
import org.test.repositories.EmployeeRepository;

@Controller
public class IndexController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "This is Spring boot multi module project");
		long count = employeeRepository.count();
		if(count > 0) {			
			employeeRepository.deleteAll();
		}
		List<Employee> list = new ArrayList<>();
		for(int i = 1 ;i <= 5 ;i++) {
			list.add(new Employee("Employee"+i, "Designation"+i));
		}
		employeeRepository.saveAll(list);
		return "index";
	}
	
	@GetMapping("/view")
	public String view(Model model) {
		List<Employee> list = employeeRepository.findAll();
		model.addAttribute("listEmployees",list);
		return "view";
	}
}