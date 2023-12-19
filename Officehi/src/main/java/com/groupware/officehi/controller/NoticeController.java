package com.groupware.officehi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoticeController {
	
	// 공지사항 관리
	@GetMapping("admin/notices")
	public String noticeTotal() {
		return "admin/notices/noticeTotal";
	}
	
	@PostMapping("admin/notices")
	public String noticeModify() {
		return "redirect:/admin/notices";
	}
	
	@GetMapping("admin/notices/add")
	public String noticeAddForm() {
		return "admin/notices/noticeAddForm";
	}
	
//	@GetMapping("admin/notices/{notice_no}")
	@GetMapping("admin/notices/1")
	public String noticeDetail() {
		return "admin/notices/noticeDetail";
	}

}
