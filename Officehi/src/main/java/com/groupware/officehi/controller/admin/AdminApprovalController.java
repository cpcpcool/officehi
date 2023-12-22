package com.groupware.officehi.controller.admin;

import java.util.List;

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
import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.service.ApprovalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/approvals")
public class AdminApprovalController {

	private final ApprovalService approvalService;

	// 관리자 결재 문서 리스트
	@GetMapping("")
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

		List<ApprovalDTO> approvals = approvalService.findAllApproval();
		model.addAttribute("approvals", approvals);
		return "admin/approvals/approvalTotal";
	}
}
