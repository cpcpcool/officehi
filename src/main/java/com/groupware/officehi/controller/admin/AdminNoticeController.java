package com.groupware.officehi.controller.admin;

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

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.dto.PagingDTO;
import com.groupware.officehi.service.NoticeService;

import lombok.RequiredArgsConstructor;

/**
* @author 이승준
* @editDate 23.12.21 ~ 23.12.28
*/

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/notices")
public class AdminNoticeController {

	private final NoticeService noticeService;
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

	@GetMapping
	public String adminNotices(@ModelAttribute Paging paging, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		int totalRow = noticeService.findAll().size();
		List<NoticeDTO> notices = noticeService.findAllPaging(paging);
		
		model.addAttribute("notices", notices);
		model.addAttribute("pageMaker", new PagingDTO(paging, totalRow));
		return "/admin/notices/noticeTotal";
	}

	@GetMapping("/add")
	public String add(Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		model.addAttribute("notice", new NoticeDTO());
		return "/admin/notices/noticeAddForm";
	}

	@PostMapping("/add")
	public String postAdd(@ModelAttribute NoticeDTO notice, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		noticeService.insertNotice(notice);
		return "redirect:/admin/notices";
	}

	@GetMapping("/{noticeNo}")
	public String detail(@PathVariable("noticeNo") Long noticeNo, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		NoticeDTO notice = noticeService.findByNoticeNo(noticeNo).get();
		model.addAttribute("notice", notice);
		return "/admin/notices/noticeDetail";
	}

	@PostMapping("/{noticeNo}")
	public String adminUpdate(@ModelAttribute NoticeDTO notice, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		noticeService.updateNoticeInfo(notice);
		return "redirect:/admin/notices";
	}
	
	@DeleteMapping("/{noticeNo}")
	public String delete(@PathVariable Long noticeNo, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		noticeService.deleteNotice(noticeNo);
		return "redirect:/admin/notices";
	}
	
	@GetMapping("/search")
	public String search(String search, String searchValue, 
			@ModelAttribute Paging paging, Model model, HttpServletRequest request) {
		if(loginCheck(request, model))
			return "redirect:/login";
		
		if (loginUser.getAdmin() != 1)
			return "alert/alert";
		
		List<NoticeDTO> notices;
		int totalRow = 0;
		
		switch(search) {
		case "title":
			totalRow = noticeService.findAllByTitle(searchValue).size();
			notices = noticeService.findAllByTitlePaging(searchValue, paging);
			break;
		case "content":
			totalRow = noticeService.findAllByContent(searchValue).size();
			notices = noticeService.findAllByContentPaging(searchValue, paging);
			break;
		case "noticeNo":
			totalRow = noticeService.findAllByNoticeNo(Long.valueOf(searchValue)).size();
			notices = noticeService.findAllByNoticeNoPaging(Long.valueOf(searchValue), paging);
			break;
		default:
			return "admin/notices/noticeTotal";
		}
		
		model.addAttribute("notices", notices);
		model.addAttribute("pageMaker", new PagingDTO(paging, totalRow));
		return "admin/notices/noticeTotal";
	}
}