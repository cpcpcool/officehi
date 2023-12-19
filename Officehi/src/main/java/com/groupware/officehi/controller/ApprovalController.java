package com.groupware.officehi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.service.ApprovalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/approvals")
public class ApprovalController {
	private final ApprovalService service;
	
	@GetMapping("")
	public String getApprovals(Model model) {
		List<ApprovalDTO.ApprovalListDTO> approvals = service.approvalList();
		
		model.addAttribute("approvals", approvals);
		
		return "user/approval/approvalList";
	}
	
	@GetMapping("/add")
	public String getApprovalNo(Model model) {
		List<ApprovalDTO.ApprovalUserList> userList = service.findByUserNameAndDeptName();
		model.addAttribute("userList", userList);
		return "user/approval/approvalAddForm";
	}
	
	@PostMapping("/add")
	public String saveApproval(@ModelAttribute ApprovalDTO.ApprovalSaveDTO saveDTO) {
		service.save(saveDTO);
		return "redirect:/approvals";
	}
	
	@GetMapping("/sub")
	public String sub() {
		return "user/approval/sub";
	}
	
}
