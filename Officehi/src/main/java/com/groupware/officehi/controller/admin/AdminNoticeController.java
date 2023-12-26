package com.groupware.officehi.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@Slf4j
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
		log.info("notices >> " + notices.toString());
		return "admin/notices/noticeTotal";
	}
}