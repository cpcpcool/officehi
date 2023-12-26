package com.groupware.officehi.controller.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.service.NoticeService;

import lombok.RequiredArgsConstructor;
/**
 * @author 정유진
 * @editDate 23.12.19 ~ 23.12.20
*/

@Controller
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticeController {

	private final NoticeService noticeService;

	@GetMapping("")
	public String notices(Model model) {
		List<NoticeDTO> notices = noticeService.findAll();
		model.addAttribute("notices", notices);
		return "/user/notices/noticeList";
	}

	@GetMapping("/{noticeNo}")
	public String noticeDetail(@PathVariable("noticeNo") Long noticeNo, Model model) {
		NoticeDTO notice = noticeService.findByNoticeNo(noticeNo).get();
		model.addAttribute("notice", notice);
		return "/user/notices/notice";
	}

}
