package com.groupware.officehi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.WorkDTO;
import com.groupware.officehi.repository.WorkRepository;
import com.groupware.officehi.service.WorkService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WorkController {

	private final WorkService workService;

	@Autowired
	public WorkController(WorkService workService) {
		this.workService = workService;
	}
	
	public class SessionConst {
		public static final String LOGIN_MEMBER = "loginMember";
	}

	@GetMapping("/works")
	public String workTime() {
		return "/user/works/workTime";
	}

	@PostMapping("/works/arrival")
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
			return "redirect:/works";
		}else {
			WorkDTO work = new WorkDTO();
			work.setUserNo(loginUser.getUserNo());
			workService.arrivalTimeCheck(work);
			return "redirect:/works";
		}
		
	}	

	@PostMapping("/works/leave")
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
		return "redirect:/works";
	}

	@GetMapping("/works/list")
	public String workList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginUser == null)
        	return "redirect:/login";
        
        loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
        List<WorkDTO> works = workService.workTimesByUserNo(loginUser.getUserNo());
		model.addAttribute("works", works);
        return "/user/works/workList";
	}

	@GetMapping("/works/list/all")
	public String findAllWorks(Model model) {
		List<WorkDTO> works = workService.workTimes();
		model.addAttribute("works", works);
		return "/user/works/workList";
	}
}
