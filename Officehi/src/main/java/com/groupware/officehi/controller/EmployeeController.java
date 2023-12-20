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
	public String noticeModify() {
		return "redirect:/admin/employees";
	}

	@GetMapping("/admin/employees/add")
	public String noticeAddForm() {
		return "admin/employees/employeeAddForm";
	}

//	@GetMapping("admin/employees/{notice_no}")
	@GetMapping("/admin/employees/1")
	public String noticeDetail() {
		return "admin/employees/employeeDetail";
	}

}
