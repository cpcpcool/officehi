package com.groupware.officehi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.service.ApprovalService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = {"/approvals", "/admin"})
public class ApprovalController {
	private final ApprovalService service;
	
	// 결재 현황 조회
	@GetMapping("")
	public String getApprovalList(Model model) {
		List<ApprovalDTO> approvals = service.findAllApproval();
		model.addAttribute("approvals", approvals);
		return "user/approval/approvalList";
	}
	
	// 결재 문서 작성
	@GetMapping("/add")
	public String getApprovalAddForm (Model model) {
		List<ApprovalDTO> userList = service.findAllUserNameAndDeptName();
		model.addAttribute("userList", userList);
		return "user/approval/approvalAddForm";
	}
	
	// 결재 문서 작성 버튼 선택
	@PostMapping("/add")
	public String addApproval(@ModelAttribute ApprovalDTO insert) {
		service.insertApproval(insert);
		return "redirect:/approvals";
	}
	
	// 결재 문서 상세 보기
	@GetMapping("/{approval_no}")
	public String getApproval(@PathVariable Long approval_no, Model model) {
		ApprovalDTO approval = service.findByApprovalNo(approval_no).get();
		List<ApprovalDTO> userList = service.findAllUserNameAndDeptName();
		log.info("checker1 >> {}", approval.getChecker1());
		model.addAttribute("approval", approval);
		model.addAttribute("userList", userList);
		
		return "user/approval/approval";
	}
	
	// 결재 문서 수정 버튼 선택
	@PostMapping("/{approval_no}")
	public String editApproval(@PathVariable Long approval_no, @ModelAttribute ApprovalDTO update) {
		update.setApprovalNo(approval_no);
		service.updateApproval(update);
		return "redirect:/approvals";
	}
	
	// 결재 문서 삭제 버튼 선택
	@PostMapping("/{approval_no}/delete")
	public String deleteApproval(@RequestParam Long approvalNo) {
		log.info("approvalNo : {}", approvalNo);
		service.updateApproval(approvalNo);
		return "redirect:/approvals";
	}
	
	// 관리자 결재 문서 리스트
	@GetMapping("/approvals")
	public String getAdminApprovalList(Model model) {
		List<ApprovalDTO> approvals = service.findAllApproval();
		model.addAttribute("approvals", approvals);
		return "admin/approval/approvalTotal";
	}
	
	// 승인, 반려버튼 선택시
	@PostMapping("/{approvalNo}/status")
	public String setApprovalStatus(@PathVariable Long approvalNo, @ModelAttribute ApprovalDTO approval) {
		service.updateStatus(approval);
		return "redirect:/approvals";
	}
}
