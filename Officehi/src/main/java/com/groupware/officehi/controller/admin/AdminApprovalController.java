package com.groupware.officehi.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// 결재 문서 상세 보기
	@GetMapping("/{approval_no}")
	public String getApproval(@PathVariable Long approval_no, HttpServletRequest request, Model model) {
		if(loginCheck(request, model))
			return "redirect:/login";

		ApprovalDTO approval = approvalService.findByApprovalNo(approval_no).get();
		model.addAttribute("approval", approval);

		return "user/approvals/approval";
	}
	
	@GetMapping("/search")
	public String getAdminApprovalListSearch(@RequestParam String searchType, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return "redirect:/login";

		LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return "redirect:/login";

		if (loginUser.getAdmin() != 1)
			return "redirect:/main";

		model.addAttribute("loginUser", loginUser);
		Object serachValue = model.getAttribute("serachValue");
		
		List<ApprovalDTO> approvals = null;
		
		switch(searchType) {
		case "approvalNo":
			approvals = approvalService.findApprovalByUserNo((Long)serachValue);
			break;
		case "userNo":
			approvals = approvalService.findApprovalByUserNo((Long)serachValue);
			break;
		case "title":
			approvals = approvalService.findApprovalByTitle(serachValue.toString());
			break;
		case "deptName":
			approvals = approvalService.findApprovalByDeptName(serachValue.toString());
			break;
		case "date":
			approvals = approvalService.findApprovalBydate(serachValue.toString());
			break;
		case "checkDate":
			approvals = approvalService.findApprovalByCheckDate(serachValue.toString());
			break;
		}
		
		model.addAttribute("approvals", approvals);
		return "admin/approvals/approvalTotal";
	}
}
