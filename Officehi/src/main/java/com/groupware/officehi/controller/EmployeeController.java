package com.groupware.officehi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping("/admin/employees")
	public String employeeList(Model model) {
		List<EmployeeDTO> employees = employeeRepository.findAllEmployee();
		model.addAttribute("employees", employees);
		return "admin/employees/employeeTotal";
	}

	@PostMapping("/admin/employees")
	public String employeeModify() {
		return "redirect:/admin/employees";
	}

	@GetMapping("/admin/employees/add")
	public String employeeAddForm(Model model) {
		EmployeeDTO lastUser = new EmployeeDTO();
		List<EmployeeDTO> empList = employeeRepository.findAllEmployee();
		if(!empList.isEmpty())
			lastUser = empList.get(empList.size()-1);
		else
			lastUser.setUserNo(10000L);
		model.addAttribute("lastUserNo", lastUser.getUserNo()+1);
		return "admin/employees/employeeAddForm";
	}

	@PostMapping("/admin/employees/add")
	public String employeeAdd(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
		employeeRepository.saveUserInfo(employeeDTO);
		model.addAttribute("employeeDTO", employeeDTO);
		return "redirect:/admin/employees";
	}

	@GetMapping("admin/employees/{userNo}")
	public String employeeDetail(@PathVariable Long userNo, Model model) {
		Optional<EmployeeDTO> employee = employeeRepository.findByUserNo(userNo);
		if(employee.get().getFromDate().equals("9999-01-01")) {
			employee.get().setFromDate("-");
		}
		
		model.addAttribute("employee", employee.get());
		return "admin/employees/employeeDetail";
	}

//	@PostMapping("admin/employees/{userNo}")
//	public String employeeInfoEdit(@PathVariable Long userNo, Model model) {
//		employeeRepository.updateUserInfo(userNo);
//		return "admin/employees/{userNo}";
//	}

}
