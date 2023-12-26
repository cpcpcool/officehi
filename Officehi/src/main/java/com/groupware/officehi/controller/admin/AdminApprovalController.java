package com.groupware.officehi.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.service.ApprovalService;

import lombok.RequiredArgsConstructor;

/**
 * @author 엄다빈
 * @editDate 23.12.18 ~23.12.26
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/approvals")
public class AdminApprovalController {

	private final ApprovalService approvalService;

	// 관리자 결재 문서 리스트
	@GetMapping
	public String getAdminApprovalList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return "redirect:/login";

		LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "redirect:/main";

		model.addAttribute("loginUser", loginUser);

		List<ApprovalDTO> approvals = approvalService.findApproval();
		model.addAttribute("approvals", approvals);
		return "admin/approvals/approvalTotal";
	}
	
	@GetMapping("/search")
	public String getAdminApprovalListSearch(@RequestParam String search, @RequestParam String searchValue, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return "redirect:/login";

		LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "redirect:/main";

		model.addAttribute("loginUser", loginUser);
		
		List<ApprovalDTO> approvals = null;
		
		switch(search) {
		case "approvalNo":
			approvals = approvalService.findApprovalByApprovalNo(Long.valueOf(searchValue));
			break;
		case "userName":
			approvals = approvalService.findApprovalByUserName(searchValue);
			break;
		case "title":
			approvals = approvalService.findApprovalByTitle(searchValue);
			break;
		case "deptName":
			approvals = approvalService.findApprovalByDeptName(searchValue);
			break;
		case "date":
			approvals = approvalService.findApprovalBydate(searchValue);
			break;
		case "checkDate":
			approvals = approvalService.findApprovalByCheckDate(searchValue);
			break;
		}
		
		model.addAttribute("approvals", approvals);
		return "admin/approvals/approvalTotal";
	}
}
