package com.groupware.officehi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	
	private final NoticeService service;
	
	public NoticeController(NoticeService service) {
		this.service = service;
	}
	
	@GetMapping("/notices")
	public String notices(Model model) {
		List<NoticeDTO> notices = service.findAll();
		model.addAttribute("notices", notices);
		return "/user/notices/noticeList";
	}
	
	@GetMapping("/notices/{noticeNo}")
	public String noticeDetail(@PathVariable("noticeNo") Long noticeNo, Model model) {
		NoticeDTO notice = service.findById(noticeNo).get();
		model.addAttribute("notice", notice);
		return "/user/notices/notice";
	}

	@GetMapping("/admin/notices")
	public String adminNotices(Model model) {
		List<NoticeDTO> notices = service.findAll();
		model.addAttribute("notices", notices);
		log.info("notice : >> " + notices.get(0).getNoticeNo());
		return "/admin/notices/noticeTotal";
	}
	
	@GetMapping("/admin/notices/add")
	public String add(Model model) {
		model.addAttribute("notice", new NoticeDTO());
		return "/admin/notices/noticeAddForm";
	}
	
	@PostMapping("/admin/notices/add")
	public String postAdd(@ModelAttribute NoticeDTO notice) {
		service.insertNotice(notice);
		return "redirect:/admin/notices";
	}
	
	@GetMapping("/admin/notices/{noticeNo}")
	public String detail(@PathVariable("noticeNo") Long noticeNo, Model model) {
		NoticeDTO notice = service.findById(noticeNo).get();
		model.addAttribute("notice", notice);
		return "/admin/notices/noticeDetail";
	}
	
	@PostMapping("/admin/notices/{noticeNo}")
	public String adminUpdate(@PathVariable("noticeNo") Long noticeNo) {
		return "redirect:/admin/notices";
	}
}
