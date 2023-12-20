package com.groupware.officehi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.MyPage;
import com.groupware.officehi.service.MyPageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyPageController {
	
	private final MyPageService service;
	
	public MyPageController(MyPageService service) {
		this.service = service;
	}
	
	public class SessionConst {
		public static final String LOGIN_MEMBER = "loginMember";
	}
	
	@GetMapping("/mypage")
	public String myPageDetail(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession(false);
		if (session == null)
		return "redirect:/login";

		LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
		if(loginUser == null)
			return "redirect:/login";
		
		model.addAttribute("loginUser", loginUser);
		
		List<MyPage> myPages = service.findByAll();
		model.addAttribute("myPages", myPages);
		return "user/myPage";
	}

}
