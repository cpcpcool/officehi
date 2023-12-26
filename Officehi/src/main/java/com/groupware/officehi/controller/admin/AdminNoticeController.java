package com.groupware.officehi.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
* @author 이승준
* @editDate 23.12.21 ~ 23.12.22
* 검색 기능 추가 23.12.24 ~ 23.12.26
*/

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/notices")
public class AdminNoticeController {

	private final NoticeService noticeService;

	@GetMapping("")
	public String adminNotices(Model model) {
		List<NoticeDTO> notices = noticeService.findAll();
		model.addAttribute("notices", notices);
		return "/admin/notices/noticeTotal";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("notice", new NoticeDTO());
		return "/admin/notices/noticeAddForm";
	}

	@PostMapping("/add")
	public String postAdd(@ModelAttribute NoticeDTO notice) {
		noticeService.insertNotice(notice);
		return "redirect:/admin/notices";
	}

	@GetMapping("/{noticeNo}")
	public String detail(@PathVariable("noticeNo") Long noticeNo, Model model) {
		NoticeDTO notice = noticeService.findByNoticeNo(noticeNo).get();
		model.addAttribute("notice", notice);
		return "/admin/notices/noticeDetail";
	}

	@PostMapping("/{noticeNo}")
	public String adminUpdate(@PathVariable("noticeNo") Long noticeNo) {
		return "redirect:/admin/notices";
	}
}
