package com.groupware.officehi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.groupware.officehi.dto.Notice;
import com.groupware.officehi.service.NoticeService;

@Controller
public class NoticeController {
	
	private final NoticeService service;
	
	public NoticeController(NoticeService service) {
		this.service = service;
	}
	
	@GetMapping("/notices")
	public String notices(Model model) {
		List<Notice> notices = service.findByAll();
		model.addAttribute("notices", notices);
		return "user/notices/noticeList";
	}
	
	@GetMapping("/notices/{notice_no}")
	public String noticeDetail(@PathVariable("notice_no") Long notice_no, Model model) {
		Notice notice = service.findById(notice_no).get();
		model.addAttribute("notice", notice);
		return "/user/notices/notice";
	}
	
	//사원정보폼 컨트롤러
}