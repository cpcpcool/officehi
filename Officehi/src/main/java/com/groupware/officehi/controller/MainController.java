package com.groupware.officehi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.dto.WorkDTO;
import com.groupware.officehi.service.ApprovalService;
import com.groupware.officehi.service.EmployeeService;
import com.groupware.officehi.service.NoticeService;
import com.groupware.officehi.service.WorkService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final NoticeService noticeService;
	private final ApprovalService approvalService;
	private final WorkService workService;
	private final EmployeeService employeeService;
	
	public class SessionConst {
	    public static final String LOGIN_MEMBER = "loginMember";
	}
	
	@GetMapping("/main")
	public String main(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
	    if (session == null) {
	        return "redirect:/login";
	    }
	    LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
	    // null 검사 필요
	    Optional<EmployeeDTO> user = employeeService.findByUserNo(loginUser.getUserNo());
	    model.addAttribute("user", user.get());
	    
	    Optional<NoticeDTO> notice = noticeService.findAll().stream().findFirst();
	    if(notice.isPresent())
	    	model.addAttribute("notice", notice.get());
	    
	    List<ApprovalDTO> approvals = approvalService.findAllApprovalByUserNo(loginUser.getUserNo());
		model.addAttribute("approvals", approvals.stream().limit(7).collect(Collectors.toList()));
	    return "/user/main";
	}
	
	@PostMapping("/main/arrival")
	public String arrival(RedirectAttributes redirectAttributes, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) 
            return "redirect:/login";
		
		LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
		loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		
		Integer duplicateCheck = workService.checkDateDuplicte(loginUser.getUserNo());
		if (duplicateCheck != null) {
			// log.info("{}", duplicateCheck);
			// redirect면 새로운 요청으로 전달되기 때문에 model.addAttribute로는  
			// 뷰로 넘어가지 않아 <c:if>로 duplicateMessage 요소가 생기지 않음
			redirectAttributes.addFlashAttribute("duplicateMessage", "이미 출근한 날짜입니다.");
			return "redirect:/main";
		}else {
			WorkDTO work = new WorkDTO();
			work.setUserNo(loginUser.getUserNo());
			workService.arrivalTimeCheck(work);
			return "redirect:/main";
		}
		
	}	

	@PostMapping("/main/leave")
	public String leave(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) 
            return "redirect:/login";
		
		LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
		loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		
		
		WorkDTO work = new WorkDTO();
		work.setUserNo(loginUser.getUserNo());
		workService.leaveTimeCheck(work);
		return "redirect:/main";
	}

}
