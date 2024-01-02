package com.groupware.officehi.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.PagingDTO;
import com.groupware.officehi.service.ApprovalService;
import com.groupware.officehi.service.EmployeeService;

import lombok.RequiredArgsConstructor;

/**
 * @author 엄다빈
 * @editDate 23.12.18 ~ 23.12.26
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/approvals")
public class AdminApprovalController {

	private final ApprovalService approvalService;
	private final EmployeeService employeeService;
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
	
	// 관리자 결재 문서 리스트
	@GetMapping
	public String getAdminApprovalList(@ModelAttribute Paging paging, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		int totalRow = approvalService.findAll(null).size();
		List<ApprovalDTO> approvals = approvalService.findAll(paging);
		
		model.addAttribute("approvals", approvals);
		model.addAttribute("pageMaker", new PagingDTO(paging, totalRow));
		
		return "admin/approvals/approvalTotal";
	}
	
	// 결재 문서 상세 보기
	@GetMapping("/{approval_no}")
	public String getApproval(@PathVariable Long approval_no, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		if(loginUser.getAdmin() != 1)
			return "alert/alert";

		ApprovalDTO approval = approvalService.findByApprovalNo(approval_no).get();
		List<ApprovalDTO.Checker> checker = approvalService.findChekcerByApprovalNo(approval_no);
		
		EmployeeDTO checker1 = employeeService.findUserInfoByUserNo(checker.get(0).getUserNo()).get();
		
		if(checker.size() > 1) {
			EmployeeDTO checker2 = employeeService.findUserInfoByUserNo(checker.get(1).getUserNo()).get();
			model.addAttribute("checker2", checker2);
		} else {
			model.addAttribute("checker2", null);
		}
		
		model.addAttribute("approval", approval);
		model.addAttribute("checker1", checker1);

		return "user/approvals/approval";
	}
	
	@GetMapping("/search")
	public String getAdminApprovalListSearch(@RequestParam("search") String search, @RequestParam("searchValue") String searchValue,
			@ModelAttribute Paging paging, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";

		if(loginUser.getAdmin() != 1)
			return "alert/alert";
		
		List<ApprovalDTO> approvals;
		int totalRow = 0;
		
		switch(search) {
		case "approvalNo":
			totalRow = approvalService.findAllByApprovalNo(Long.valueOf(searchValue), null).size();
			approvals = approvalService.findAllByApprovalNo(Long.valueOf(searchValue), paging);
			break;
		case "userName":
			totalRow = approvalService.findAllByUserName(searchValue, null).size();
			approvals = approvalService.findAllByUserName(searchValue, paging);
			break;
		case "title":
			totalRow = approvalService.findAllByTitle(searchValue, null).size();
			approvals = approvalService.findAllByTitle(searchValue, paging);
			break;
		case "deptName":
			totalRow = approvalService.findAllByDeptName(searchValue, null).size();
			approvals = approvalService.findAllByDeptName(searchValue, paging);
			break;
		case "date":
			totalRow = approvalService.findAllBydate(searchValue, null).size();
			approvals = approvalService.findAllBydate(searchValue, paging);
			break;
		case "checkDate":
			totalRow = approvalService.findAllByCheckDate(searchValue, null).size();
			approvals = approvalService.findAllByCheckDate(searchValue, paging);
			break;
		default:
			return "admin/approvals/approvalTotal";
		}
		
		model.addAttribute("approvals", approvals);
		model.addAttribute("pageMaker", new PagingDTO(paging, totalRow));
		
		return "admin/approvals/approvalTotal";
	}
}
