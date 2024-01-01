package com.groupware.officehi.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.dto.ApprovalDTO.Checker;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.PagingDTO;
import com.groupware.officehi.service.ApprovalService;
import com.groupware.officehi.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 엄다빈
 * @editDate 23.12.18 ~ 23.12.26
 */

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/approvals")
public class ApprovalController {

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
	
	// 결재 현황 조회
	@GetMapping
	public String getApprovalList(@ModelAttribute Paging paging, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		int total = approvalService.findApprovalByUserNoOrChecker(loginUser.getUserNo(), null).size();
		List<ApprovalDTO> approvals = approvalService.findApprovalByUserNoOrChecker(loginUser.getUserNo(), paging);
		
		model.addAttribute("approvals", approvals);
		model.addAttribute("pageMaker", new PagingDTO(paging, total));
		
		return "user/approvals/approvalList";
	}
	
	// 결재 문서 수정 버튼 선택
	@PutMapping("/{approvalNo}")
	public String editApproval(@PathVariable Long approvalNo, @ModelAttribute ApprovalDTO approval,
			@RequestParam Long checker1, @RequestParam Long checker2, @RequestParam int confirm,
			Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";

		approval.setApprovalNo(approvalNo);
		approvalService.updateApproval(approval);
		
		approvalService.updateChecker(new ApprovalDTO.Checker(approvalNo, 1, confirm, checker1));
		
		if(checker2 != 0) {
			if(approvalService.findChekcerByApprovalNo(approvalNo).size() < 2) {
				approvalService.insertChecker(new ApprovalDTO.Checker(approvalNo, 2, 0, checker2));
			} else {
				approvalService.updateChecker(new ApprovalDTO.Checker(approvalNo, 2, 0, checker2));
			}
		} else {
			approvalService.deleteChecker(approvalNo, 2);
		}
		
		return "redirect:/approvals";
	}

	// 결재 문서 삭제 버튼 선택
	@DeleteMapping("/{approvalNo}")
	public String deleteApproval(@PathVariable Long approvalNo, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";

		approvalService.delete(approvalNo);

		return "redirect:/approvals";
	}

	// 기안문, 참조문 보기 버튼 선택
	@GetMapping("/search")
	public String getApprovalListSearch(@RequestParam String search, @ModelAttribute Paging paging,
			Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		int total;
		List<ApprovalDTO> approvals;
		
		if(search.equals("my")) {
			total = approvalService.findAllByUserNo(loginUser.getUserNo(), null).size();
			approvals = approvalService.findAllByUserNo(loginUser.getUserNo(), paging);
		} else if(search.equals("other")){ 
			total = approvalService.findAllByChecker(loginUser.getUserNo(), null).size();
			approvals = approvalService.findAllByChecker(loginUser.getUserNo(), paging);
		} else {
			return "redirect:/approvals";
		}
		
		model.addAttribute("approvals", approvals);
		model.addAttribute("pageMaker", new PagingDTO(paging, total));
		
		return "user/approvals/approvalList";
	}

	// 결재 문서 작성
	@GetMapping("/add")
	public String getApprovalAddForm(Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";

		List<ApprovalDTO> userList = approvalService.findUserNameAndDeptName(loginUser.getUserNo());
		
		model.addAttribute("userList", userList);
		model.addAttribute("approval", new ApprovalDTO());
		model.addAttribute("checker", new ApprovalDTO.Checker());
		
		return "user/approvals/approvalAddForm";
	}
	
	// 결재 문서 작성 버튼 선택
	@PostMapping("/add")
	public String addApproval(@RequestParam Long checker1, @RequestParam Long checker2, @ModelAttribute ApprovalDTO approval,
			Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";

		approval.setUserNo(loginUser.getUserNo());
		approvalService.insertApproval(approval);
		
		approvalService.insertChecker(new ApprovalDTO.Checker(approval.getApprovalNo(), 1, 0, checker1));
		
		if(checker2 != 0)
			approvalService.insertChecker(new ApprovalDTO.Checker(approval.getApprovalNo(), 2, 0, checker2));
		
		return "redirect:/approvals";
	}

	// 결재 문서 상세 보기
	@GetMapping("/{approvalNo}")
	public String getApproval(@PathVariable Long approvalNo, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";

		ApprovalDTO approval = approvalService.findByApprovalNo(approvalNo).get();
		List<ApprovalDTO> userList = approvalService.findUserNameAndDeptNameByApprovalNo(approval.getApprovalNo(), loginUser.getUserNo());
		List<ApprovalDTO.Checker> checker = approvalService.findChekcerByApprovalNo(approvalNo);
		
		EmployeeDTO checker1 = employeeService.findUserInfoByUserNo(checker.get(0).getUserNo()).get();
		
		if(checker.size() > 1) {
			EmployeeDTO checker2 = employeeService.findUserInfoByUserNo(checker.get(1).getUserNo()).get();
			model.addAttribute("checker2", checker2);
		} else {
			model.addAttribute("checker2", null);
		}
		
		model.addAttribute("approval", approval);
		model.addAttribute("userList", userList);
		model.addAttribute("checker1", checker1);

		return "user/approvals/approval";
	}

	// 수정, 진행, 반려, 최종승인 버튼 선택시
	@PutMapping("status/{approvalNo}")
	public String setApprovalStatus(@PathVariable Long approvalNo, @ModelAttribute ApprovalDTO approval,
			@RequestParam Long checker1, @RequestParam Long checker2,
			Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";

		approvalService.updateStatus(approval);
		
		switch(approval.getStatus()) {
		case 2:
			approvalService.updateChecker(new ApprovalDTO.Checker(approvalNo, 1, 1, checker1));
			break;
		case 3:
			approvalService.updateChecker(new ApprovalDTO.Checker(approvalNo, 1, 1, checker1));
			break;
		case 4:
			approvalService.updateChecker(new ApprovalDTO.Checker(approvalNo, 2, 1, checker2));
			break;
		}
		
		return "redirect:/approvals";
	}
}
