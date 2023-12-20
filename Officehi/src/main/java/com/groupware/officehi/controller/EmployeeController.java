package com.groupware.officehi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

	@GetMapping("/admin/employees")
	public String employeeList() {
		return "admin/employees/employeeTotal";
	}

	@PostMapping("/admin/employees")
	public String employeeModify() {
		return "redirect:/admin/employees";
	}

	@GetMapping("/admin/employees/add")
	public String employeeAddForm() {
		return "admin/employees/employeeAddForm";
	}

	@PostMapping("/admin/employees/add")
	public String employeeAdd() {
		return "redirect:/admin/employees";
	}	

//	@GetMapping("/admin/employees/1")
	@GetMapping("admin/employees/{userNo}")
	public String employeeDetail() {
		return "admin/employees/employeeDetail";
	}
	
//	@PostMapping("/admin/employees/1")
	@PostMapping("admin/employees/{employee_no}")
	public String employeeInfoEdit() {
		return "admin/employees/{employee_no}";
	}

}
