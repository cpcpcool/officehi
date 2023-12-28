package com.groupware.officehi.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.NoticeDTO;
import com.groupware.officehi.dto.PagingDTO;
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
	public String notices(HttpServletRequest request, Paging paging, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return "redirect:/login";

		LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return "redirect:/login";

		model.addAttribute("loginUser", loginUser);
		
		int totalRow = noticeService.findAll().size();
		List<NoticeDTO> notices = noticeService.findNoticePaging(paging);
		model.addAttribute("notices", notices);
		model.addAttribute("pageMaker", new PagingDTO(paging, totalRow));
		return "/user/notices/noticeList";
	}

	@GetMapping("/{noticeNo}")
	public String noticeDetail(@PathVariable("noticeNo") Long noticeNo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return "redirect:/login";

		LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return "redirect:/login";

		model.addAttribute("loginUser", loginUser);
		
		NoticeDTO notice = noticeService.findByNoticeNo(noticeNo).get();
		model.addAttribute("notice", notice);
		return "/user/notices/notice";
	}
}
