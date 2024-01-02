package com.groupware.officehi.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.dto.FileDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.PagingDTO;
import com.groupware.officehi.service.EmployeeService;
import com.groupware.officehi.service.LoginService;

import lombok.RequiredArgsConstructor;

/**
 * @author 박재용
 * @editDate 23.12.20 ~ 23.12.22 
 * 페이지네이션 기능 추가 23.12.23 ~ 23.12.25
 * 파일 업로드 및 수정 기능 추가 23.12.26 ~ 23.12.29
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/employees")
public class AdminEmployeeController {

	private final EmployeeService employeeService;
	private final LoginService loginService;
	public LoginUserDTO loginUser = null;

	// 로그인 검증
	public boolean loginCheck(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return true;

		this.loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return true;

		model.addAttribute("loginUser", loginUser);
		return false;
	}

	@GetMapping
	public String employeeList(@ModelAttribute Paging paging, Model model, HttpServletRequest request) {
		if (loginCheck(request, model))
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "alert/alert";

		int totalRow = employeeService.findAllEmployee(null).size();
		List<EmployeeDTO> employees = employeeService.findAllEmployee(paging);
		
		model.addAttribute("employees", employees);
		model.addAttribute("pageMaker", new PagingDTO(paging, totalRow));

		return "admin/employees/employeeTotal";
	}

	@GetMapping("/search")
	public String searchEmployeeList(@RequestParam("searchType") String searchType,
									@RequestParam(name = "name", required = false) String name,
									@RequestParam(name = "userNo", required = false) Long userNo,
									@RequestParam(name = "deptName", required = false) String deptName, 
									@ModelAttribute Paging paging, Model model, HttpServletRequest request) {

		if (loginCheck(request, model))
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "alert/alert";

		List<EmployeeDTO> employees = null;
		int totalRow = 0;
		
		if(searchType.equals("name")) {
			totalRow = employeeService.findAllByName(name, null).size();
			employees = employeeService.findAllByName(name, paging);
		}else if(searchType.equals("userNo")) {
			totalRow = employeeService.findAllByUserNo(userNo, null).size();
			employees = employeeService.findAllByUserNo(userNo, paging);
		}else if(searchType.equals("deptName")) {
			totalRow = employeeService.findAllByDeptName(deptName, null).size();
			employees = employeeService.findAllByDeptName(deptName, paging);
		}
		
		model.addAttribute("employees", employees);
		model.addAttribute("pageMaker", new PagingDTO(paging, totalRow));
		return "admin/employees/employeeTotal";
	}

	@GetMapping("/add")
	public String employeeAddForm(@ModelAttribute EmployeeDTO employee, Model model, 
								   HttpServletRequest request) {
		if (loginCheck(request, model))
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		EmployeeDTO lastUserNo = new EmployeeDTO();
		List<EmployeeDTO> empList = employeeService.findAllEmployee(null);
		if (!empList.isEmpty())
			lastUserNo = empList.get(0);
		else
			lastUserNo.setUserNo(9999L);
		
		model.addAttribute("lastUserNo", lastUserNo.getUserNo() + 1);
		model.addAttribute("employee", employee);
		return "admin/employees/employeeAddForm";
	}

	@PostMapping("/add")
	public String employeeAdd(@Valid @ModelAttribute EmployeeDTO employeeDTO,  
			BindingResult bindingResult,
			@RequestParam("profile") MultipartFile profileMultipartFile,
			@RequestParam("stamp") MultipartFile stampMultipartFile, 
			Model model, HttpServletRequest request, HttpSession session) {
		if (loginCheck(request, model))
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		if (bindingResult.hasErrors())
			return "admin/employees/employeeAddForm";

		employeeService.insertUserInfo(employeeDTO);
		loginService.saveUserInfo(employeeDTO.getUserNo());

		FileDTO fileDTO = new FileDTO();
		fileDTO.setUserNo(employeeDTO.getUserNo());

		// profile 증명사진 저장
		fileDTO.setMultipartFile(profileMultipartFile);
		fileDTO.setFileTypeNo("1");
		employeeService.insertFileInfo(fileDTO);

		// stamp 인감 저장
		fileDTO.setMultipartFile(stampMultipartFile);
		fileDTO.setFileTypeNo("2");
		employeeService.insertFileInfo(fileDTO);

		model.addAttribute("employeeDTO", employeeDTO);

		return "redirect:/admin/employees";
	}

	@GetMapping("/{userNo}")
	public String employeeDetail(@PathVariable Long userNo, Model model, HttpServletRequest request) {
		if (loginCheck(request, model))
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		// 유저 정보
		Optional<EmployeeDTO> employee = employeeService.findUserInfoByUserNo(userNo);
		if (employee.get().getFromDate().equals("9999-01-01")) {
			employee.get().setFromDate("-");
		}
		model.addAttribute("employee", employee.get());

		// 파일 정보
		Optional<FileDTO> profileFile = employeeService.findProfileFileByUserNo(userNo);
		if (profileFile.isPresent())
			model.addAttribute("profileFile", profileFile.get());
		else
			model.addAttribute("profileFile", profileFile.orElse(new FileDTO("-")));

		Optional<FileDTO> stampFile = employeeService.findStampFileByUserNo(userNo);
		if (stampFile.isPresent())
			model.addAttribute("stampFile", stampFile.get());
		else
			model.addAttribute("stampFile", stampFile.orElse(new FileDTO("-")));

		return "admin/employees/employeeDetail";
	}

	@PostMapping("/{userNo}")
	public String employeeInfoEdit(@PathVariable Long userNo, @ModelAttribute EmployeeDTO employeeDTO,
								@RequestParam("profile") MultipartFile profileMultipartFile,
								@RequestParam("stamp") MultipartFile stampMultipartFile, Model model, HttpServletRequest request) {
		if (loginCheck(request, model))
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setUserNo(employeeDTO.getUserNo());
		
		Optional<FileDTO> profileFile = employeeService.findProfileFileByUserNo(userNo);
		Optional<FileDTO> stampFile = employeeService.findStampFileByUserNo(userNo);
		
		if(profileFile.isEmpty()) {
			// profile 증명사진 최초등록
			fileDTO.setMultipartFile(profileMultipartFile);
			fileDTO.setFileTypeNo("1");
			employeeService.insertFileInfo(fileDTO);			
		}else {
			// profile 증명사진 변경저장
			fileDTO.setMultipartFile(profileMultipartFile);
			fileDTO.setFileTypeNo("1");
			employeeService.updateFileInfo(fileDTO);
		}
		
		if(stampFile.isEmpty()) {
			// stamp 인감 최초등록
			fileDTO.setMultipartFile(stampMultipartFile);
			fileDTO.setFileTypeNo("2");
			employeeService.insertFileInfo(fileDTO); 
		}else {
			// stamp 인감 변경저장
			fileDTO.setMultipartFile(stampMultipartFile);
			fileDTO.setFileTypeNo("2");
			employeeService.updateFileInfo(fileDTO); 
		}

		employeeService.updateUserInfo(employeeDTO);
		return "redirect:/admin/employees";
	}

	@PostMapping("/{userNo}/retired")
	public String employeeInforetired(@PathVariable Long userNo, Model model, HttpServletRequest request) {
		if (loginCheck(request, model))
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		employeeService.retiredUserInfo(userNo);
		return "redirect:/admin/employees";
	}

}
