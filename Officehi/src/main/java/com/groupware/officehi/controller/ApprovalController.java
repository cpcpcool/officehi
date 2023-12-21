package com.groupware.officehi.controller;

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

import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.service.ApprovalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"/approvals", "/admin"})
public class ApprovalController {
	private final ApprovalService service;
	
	public class SessionConst {
	    public static final String LOGIN_MEMBER = "loginMember";
	}

	// 결재 현황 조회
	@GetMapping("")
	public String getApprovalList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
        if (session == null) 
            return "redirect:/login";
        
        LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
        model.addAttribute("loginUser", loginUser);
        
		List<ApprovalDTO> approvals = service.findAllApprovalByUserNo(loginUser.getUserNo());
		model.addAttribute("approvals", approvals);
		return "user/approvals/approvalList";
	}
	
	// 결재 문서 작성
	@GetMapping("/add")
	public String getApprovalAddForm (HttpServletRequest request,Model model) {
		HttpSession session = request.getSession(false);
        if (session == null) 
            return "redirect:/login";
        
        LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
        model.addAttribute("loginUser", loginUser);
		
		List<ApprovalDTO> userList = service.findAllUserNameAndDeptName();
		model.addAttribute("userList", userList);
		model.addAttribute("approval", new ApprovalDTO());
		return "user/approvals/approvalAddForm";
	}
	
	// 결재 문서 작성 버튼 선택
	@PostMapping("/add")
	public String addApproval(HttpServletRequest request, @ModelAttribute ApprovalDTO insert, Model model) {
		HttpSession session = request.getSession(false);
        if (session == null) 
            return "redirect:/login";
        
        LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
        model.addAttribute("loginUser", loginUser);
        
        insert.setUserNo(loginUser.getUserNo());
		service.insertApproval(insert);
		return "redirect:/approvals";
	}
	
	// 결재 문서 상세 보기
	@GetMapping("/{approval_no}")
	public String getApproval(@PathVariable Long approval_no, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
        if (session == null) 
            return "redirect:/login";
        
        LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
        model.addAttribute("loginUser", loginUser);
		
		ApprovalDTO approval = service.findByApprovalNo(approval_no).get();
		List<ApprovalDTO> userList = service.findAllUserNameAndDeptName();
		
		model.addAttribute("approval", approval);
		model.addAttribute("userList", userList);
		
		return "user/approvals/approval";
	}
	
	// 결재 문서 수정 버튼 선택
	@PostMapping("/{approval_no}")
	public String editApproval(@PathVariable Long approval_no, @ModelAttribute ApprovalDTO update, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
        if (session == null) 
            return "redirect:/login";
        
        LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
        model.addAttribute("loginUser", loginUser);
        
		update.setApprovalNo(approval_no);
		service.updateApproval(update);
		
		return "redirect:/approvals";
	}
	
	// 결재 문서 삭제 버튼 선택
	@PostMapping("/{approval_no}/delete")
	public String deleteApproval(@RequestParam Long approvalNo, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
        if (session == null) 
            return "redirect:/login";
        
        LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
        model.addAttribute("loginUser", loginUser);
		
		service.updateApproval(approvalNo);
		return "redirect:/approvals";
	}
	
	// 승인, 반려버튼 선택시
	@PostMapping("/{approvalNo}/status")
	public String setApprovalStatus(@PathVariable Long approvalNo, @ModelAttribute ApprovalDTO approval, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
        if (session == null) 
            return "redirect:/login";
        
        LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
        model.addAttribute("loginUser", loginUser);
        
		service.updateStatus(approval);
		return "redirect:/approvals";
	}
	
	// 관리자 결재 문서 리스트
	@GetMapping("/approvals")
	public String getAdminApprovalList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
        if (session == null) 
            return "redirect:/login";
        
        LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
        model.addAttribute("loginUser", loginUser);
        
		List<ApprovalDTO> approvals = service.findAllApproval();
		model.addAttribute("approvals", approvals);
		return "admin/approvals/approvalTotal";
	}
}
