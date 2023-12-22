package com.groupware.officehi.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.officehi.controller.WorkController.SessionConst;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/admin/employees")
	public String employeeList(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) 
            return "redirect:/login";
		LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
		loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);

		if(loginUser.getAdmin() != 1) {
			request.setAttribute("msg", "관리자 권한이 없습니다.");
			request.setAttribute("url", "officehi/main");
			return "alert/alert";	
		}
		
		List<EmployeeDTO> employees = employeeService.findAllEmployee();
		model.addAttribute("employees", employees);
		return "admin/employees/employeeTotal";
	}

	@PostMapping("admin/employees/search")
	public String findByUserName(@RequestParam("searchType") String searchType, 
								@RequestParam(name="name", required = false) String name,
								@RequestParam(name="userNo", required = false) Long uesrNo,
								@RequestParam(name ="deptName", required = false) String deptName,
								Model model) {
		List<EmployeeDTO> employees = null;
		
		if("name".equals(searchType)) {
			employees = employeeService.searchUserName(name);			
		}else if("userNo".equals(searchType)) {
			employees = employeeService.searchUserNo(uesrNo);
		}else if("deptName".equals(searchType)) {
			employees = employeeService.searchDeptName(deptName);
		}
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
		List<EmployeeDTO> empList = employeeService.findAllEmployee();
		if (!empList.isEmpty())
			lastUser = empList.get(empList.size() - 1);
		else
			lastUser.setUserNo(9999L);
		model.addAttribute("lastUserNo", lastUser.getUserNo() + 1);
		return "admin/employees/employeeAddForm";
	}

	@PostMapping("/admin/employees/add")
	public String employeeAdd(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
		employeeService.saveUserInfo(employeeDTO);
		model.addAttribute("employeeDTO", employeeDTO);
		return "redirect:/admin/employees";
	}

	@GetMapping("admin/employees/{userNo}")
	public String employeeDetail(@PathVariable Long userNo, Model model) {
		Optional<EmployeeDTO> employee = employeeService.findByUserNo(userNo);
		if (employee.get().getFromDate().equals("9999-01-01")) {
			employee.get().setFromDate("-");
		}
		model.addAttribute("employee", employee.get());
		return "admin/employees/employeeDetail";
	}
	
	@PostMapping("admin/employees/{userNo}")
	public String employeeInfoEdit(@PathVariable Long userNo, @ModelAttribute EmployeeDTO employeeDTO) {
		employeeService.updateUserInfo(employeeDTO);
		return "redirect:/admin/employees";
	}

	@PostMapping("admin/employees/{userNo}/retired")
	public String employeeInforetired(@PathVariable Long userNo, Model model) {
		employeeService.retiredUserInfo(userNo);
		return "redirect:/admin/employees";
	}
	

}
