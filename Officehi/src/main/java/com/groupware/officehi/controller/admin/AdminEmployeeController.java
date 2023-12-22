package com.groupware.officehi.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/employees")
public class AdminEmployeeController {

	private final EmployeeService employeeService;

	@GetMapping("")
	public String employeeList(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return "redirect:/login";
		LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return "redirect:/login";
		loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);

		if (loginUser.getAdmin() != 1) {
			return "alert/alert";
		}

		List<EmployeeDTO> employees = employeeService.findAllEmployee();
		model.addAttribute("employees", employees);
		return "admin/employees/employeeTotal";
	}

	@PostMapping("/search")
	public String findByUserName(@RequestParam("searchType") String searchType,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "userNo", required = false) Long uesrNo,
			@RequestParam(name = "deptName", required = false) String deptName, Model model) {
		List<EmployeeDTO> employees = null;

		if ("name".equals(searchType)) {
			employees = employeeService.searchUserName(name);
		} else if ("userNo".equals(searchType)) {
			employees = employeeService.searchUserNo(uesrNo);
		} else if ("deptName".equals(searchType)) {
			employees = employeeService.searchDeptName(deptName);
		}
		model.addAttribute("employees", employees);
		return "admin/employees/employeeTotal";
	}

	@PostMapping("/")
	public String employeeModify() {
		return "redirect:/admin/employees";
	}

	@GetMapping("/add")
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

	@PostMapping("/add")
	public String employeeAdd(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
		employeeService.insertUserInfo(employeeDTO);
		model.addAttribute("employeeDTO", employeeDTO);
		return "redirect:/admin/employees";
	}

	@GetMapping("/{userNo}")
	public String employeeDetail(@PathVariable Long userNo, Model model) {
		Optional<EmployeeDTO> employee = employeeService.findByUserNo(userNo);
		if (employee.get().getFromDate().equals("9999-01-01")) {
			employee.get().setFromDate("-");
		}
		model.addAttribute("employee", employee.get());
		return "admin/employees/employeeDetail";
	}

	@PostMapping("/{userNo}")
	public String employeeInfoEdit(@PathVariable Long userNo, @ModelAttribute EmployeeDTO employeeDTO) {
		employeeService.updateUserInfo(employeeDTO);
		return "redirect:/admin/employees";
	}

	@PostMapping("/{userNo}/retired")
	public String employeeInforetired(@PathVariable Long userNo, Model model) {
		employeeService.retiredUserInfo(userNo);
		return "redirect:/admin/employees";
	}

}
