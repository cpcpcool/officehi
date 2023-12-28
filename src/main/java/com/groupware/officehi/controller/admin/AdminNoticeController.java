package com.groupware.officehi.controller.admin;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.service.NoticeService;

import lombok.RequiredArgsConstructor;

/**
* @author 이승준
* @editDate 23.12.21 ~ 23.12.22
* 검색 기능 추가 23.12.24 ~ 23.12.26
* 수정/삭제 기능 추가 23.12.26 ~ 23.12.27
*/

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/notices")
public class AdminNoticeController {

	private final NoticeService noticeService;
	public LoginUserDTO loginUser = null;
	
	// 세션 + 관리자 여부 체크
	public List<Boolean> sessionAndAdminCheck(HttpServletRequest request, Model model) {
		List<Boolean> loginCheckList = new ArrayList<>();
		Boolean isUser = true;
		HttpSession session = request.getSession(false);
		if (session == null) {
			loginCheckList.add(true);
			return loginCheckList;
		}

		this.loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null) {
			loginCheckList.add(true);
			return loginCheckList;
		}
		
		loginCheckList.add(false);
		if(loginUser.getAdmin() != 1)
			loginCheckList.add(isUser);
		else
			loginCheckList.add(!isUser);
		
		model.addAttribute("loginUser", loginUser);
		
		return loginCheckList;
	}

	@GetMapping("")
	public String adminNotices(HttpServletRequest request,Model model) {
		// 체크 메서드 호출
		if(sessionAndAdminCheck(request, model).get(0))
			return "redirect:/login";
		if(sessionAndAdminCheck(request, model).get(1))
			return "redirect:/main";
		
		List<NoticeDTO> notices = noticeService.findAll();
		model.addAttribute("notices", notices);
		return "/admin/notices/noticeTotal";
	}

	@GetMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		// 체크 메서드 호출
		if(sessionAndAdminCheck(request, model).get(0))
			return "redirect:/login";
		if(sessionAndAdminCheck(request, model).get(1))
			return "redirect:/main";
		
		model.addAttribute("notice", new NoticeDTO());
		return "/admin/notices/noticeAddForm";
	}

	@PostMapping("/add")
	public String postAdd(@ModelAttribute NoticeDTO notice) {
		noticeService.insertNotice(notice);
		return "redirect:/admin/notices";
	}

	@GetMapping("/{noticeNo}")
	public String detail(@PathVariable("noticeNo") Long noticeNo, HttpServletRequest request, Model model) {
		// 체크 메서드 호출
		if(sessionAndAdminCheck(request, model).get(0))
			return "redirect:/login";
		if(sessionAndAdminCheck(request, model).get(1))
			return "redirect:/main";
		
		NoticeDTO notice = noticeService.findByNoticeNo(noticeNo).get();
		model.addAttribute("notice", notice);
		return "/admin/notices/noticeDetail";
	}

	@PostMapping("/{noticeNo}")
	public String adminUpdate(@ModelAttribute NoticeDTO notice) {
		noticeService.updateNoticeInfo(notice);
		return "redirect:/admin/notices";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("searchType") String searchType,
			@RequestParam(name = "title", required = false) String title,
			@RequestParam(name = "content", required = false) String content,
			@RequestParam(name = "noticeNo", required = false) Long noticeNo, Model model) {
		List<NoticeDTO> notices = null;

		if ("title".equals(searchType)) {
			notices = noticeService.searchTitle(title);
		} else if ("content".equals(searchType)) {
			notices = noticeService.searchContent(content);
		} else if ("noticeNo".equals(searchType)) {
			notices = noticeService.searchNoticeNo(noticeNo);
		}
		model.addAttribute("notices", notices);
		return "admin/notices/noticeTotal";
	}
	
	@DeleteMapping("/{noticeNo}")
	public String delete(@PathVariable Long noticeNo, Model model) {
		noticeService.deleteNotice(noticeNo);
		return "redirect:/admin/notices";
	}
}