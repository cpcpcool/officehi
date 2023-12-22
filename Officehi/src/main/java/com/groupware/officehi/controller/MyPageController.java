package com.groupware.officehi.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.MyPageDTO;
import com.groupware.officehi.service.MyPageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyPageController {
	
	private final MyPageService myPageService;
	
	@Autowired
	public MyPageController(MyPageService service) {
		this.myPageService = service;
	}
	
	public class SessionConst {
		public static final String LOGIN_MEMBER = "loginMember";
	}
	
	@GetMapping("/mypage")
	public String myPageDetail(HttpServletRequest request, Long userNo, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null)
		return "redirect:/login";

		LoginUserDTO loginUser = (LoginUserDTO)session.getAttribute(SessionConst.LOGIN_MEMBER);
		if(loginUser == null)
			return "redirect:/login";
		
		

		model.addAttribute("loginUser", loginUser);
		
		Optional<MyPageDTO> mypageuser = myPageService.findByUserNo(loginUser.getUserNo());
		if (mypageuser.get().getFromDate().equals("9999-01-01")) {
			mypageuser.get().setFromDate("-");
		}
		model.addAttribute("mypageuser", mypageuser.get());
		return "user/myPage";
	}
}
