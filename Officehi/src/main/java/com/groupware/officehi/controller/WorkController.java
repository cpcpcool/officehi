package com.groupware.officehi.controller;

import java.util.List;

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

	@GetMapping("/works")
	public String workTime() {
		return "/user/works/workTime";
	}

	@PostMapping("/works/arrival")
	public String arrival(@RequestParam Long userNo, RedirectAttributes redirectAttributes) {
		
		Integer duplicateCheck = workService.checkDateDuplicte(userNo);
		
		if (duplicateCheck != null) {
			log.info("{}", duplicateCheck);
			// return "redirect:/works"; 
			// redirect면 새로운 요청으로 전달되기 때문에 model.addAttribute로는  
			// 뷰로 넘어가지 않아 <c:if>로 duplicateMessage 요소가 생기지 않음
			redirectAttributes.addFlashAttribute("duplicateMessage", "이미 출근한 날짜입니다.");
			return "redirect:/works";
		}else {
			WorkDTO work = new WorkDTO();
			work.setUserNo(userNo);
			workService.arrivalTimeCheck(work);
			return "redirect:/works";
		}
		
	}	

	@PostMapping("/works/leave")
	public String leave(@RequestParam Long userNo) {
		WorkDTO work = new WorkDTO();
		work.setUserNo(userNo);
		workService.leaveTimeCheck(work);
		return "redirect:/works";
	}

//	@GetMapping("/works/list/{userNo}")
//	public String workList(@PathVariable Long userNo, Model model) {
//		List<Work> works = workRepository.workTimesByUserNo(userNo);
//		model.addAttribute("works", works);
//		return "/user/works/workList";
//	}

	@GetMapping("/works/list")
	public String workList(HttpSession session, Model model) {
//		session.setAttribute("loggedInUser", 10000L);
//        Long loggedInUserNo = (Long) session.getAttribute("loggedInUserNo");
//
//        if (loggedInUserNo != null) {
		// 사용자 정보가 세션에 있을 경우에만 작업 목록 가져오기
		List<WorkDTO> works = workService.workTimesByUserNo(10002L);
		model.addAttribute("works", works);
		return "/user/works/workList";
//        } else {
//            // 로그인 되어있지 않은 경우 로그인 페이지로 리다이렉트
//            return "redirect:/login";
//		}
	}

	@GetMapping("/works/list/all")
	public String findAllWorks(Model model) {
		List<WorkDTO> works = workService.workTimes();
		model.addAttribute("works", works);
		return "/user/works/workList";
	}
}
