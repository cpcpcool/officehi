package com.groupware.officehi.controller.user;

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

/**
 * @author 엄다빈
 * @editDate 23.12.18 ~23.12.26
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/approvals")
public class ApprovalController {

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
	
	// 결재 현황 조회
	@GetMapping
	public String getApprovalList(HttpServletRequest request, Model model) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		List<ApprovalDTO> approvals = approvalService.findApprovalByUserNoOrChecker(loginUser.getUserNo());
		model.addAttribute("approvals", approvals);
		return "user/approvals/approvalList";
	}
	
	// 결재 현황 조회
	@GetMapping("/search")
	public String getApprovalListSearch(@RequestParam String search, HttpServletRequest request, Model model) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		List<ApprovalDTO> approvals;
		
		if(search.equals("my"))
			approvals = approvalService.findApprovalByUserNo(loginUser.getUserNo());
		else 
			approvals = approvalService.findApprovalByChecker(loginUser.getUserNo());
		
		model.addAttribute("approvals", approvals);
		
		return "user/approvals/approvalList";
	}

	// 결재 문서 작성
	@GetMapping("/add")
	public String getApprovalAddForm(HttpServletRequest request, Model model) {
		if(loginCheck(request, model))
			return "redirect:/login";

		List<ApprovalDTO> userList = approvalService.findAllUserNameAndDeptName(loginUser.getUserNo());
		model.addAttribute("userList", userList);
		model.addAttribute("approval", new ApprovalDTO());
		return "user/approvals/approvalAddForm";
	}

	// 결재 문서 작성 버튼 선택
	@PostMapping("/add")
	public String addApproval(HttpServletRequest request, @ModelAttribute ApprovalDTO approval, Model model) {
		if(loginCheck(request, model))
			return "redirect:/login";

		approval.setUserNo(loginUser.getUserNo());
		approvalService.insertApproval(approval);
		return "redirect:/approvals";
	}

	// 결재 문서 상세 보기
	@GetMapping("/{approval_no}")
	public String getApproval(@PathVariable Long approval_no, HttpServletRequest request, Model model) {
		if(loginCheck(request, model))
			return "redirect:/login";

		ApprovalDTO approval = approvalService.findByApprovalNo(approval_no).get();
		List<ApprovalDTO> userList = approvalService.findAllUserNameAndDeptNameByApprovalNo(approval.getApprovalNo());

		model.addAttribute("approval", approval);
		model.addAttribute("userList", userList);

		return "user/approvals/approval";
	}

	// 결재 문서 수정 버튼 선택
	@PostMapping("/{approval_no}")
	public String editApproval(@PathVariable Long approval_no, @ModelAttribute ApprovalDTO approval,
			HttpServletRequest request, Model model) {
		if(loginCheck(request, model))
			return "redirect:/login";

		approval.setApprovalNo(approval_no);
		approvalService.updateApproval(approval);

		return "redirect:/approvals";
	}

	// 결재 문서 삭제 버튼 선택
	@PostMapping("/{approval_no}/delete")
	public String deleteApproval(@RequestParam Long approvalNo, HttpServletRequest request, Model model) {
		if(loginCheck(request, model))
			return "redirect:/login";

		approvalService.updateApproval(approvalNo);
		return "redirect:/approvals";
	}

	// 승인, 반려버튼 선택시
	@PostMapping("/{approvalNo}/status")
	public String setApprovalStatus(@PathVariable Long approvalNo, @ModelAttribute ApprovalDTO approval,
			HttpServletRequest request, Model model) {
		if(loginCheck(request, model))
			return "redirect:/login";

		approvalService.updateStatus(approval);
		return "redirect:/approvals";
	}

}
