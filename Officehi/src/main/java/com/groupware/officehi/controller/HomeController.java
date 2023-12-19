package com.groupware.officehi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/sub")
	public String sub() {
		return "sub";
	}

	// login가정
//	@PostMapping("/login")
//	public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
//		// 로그인 로직 (예시로 단순하게 작성)
//		User user = userRepository.findByUsernameAndPassword(username, password);
//
//		if (user != null) {
//			// 로그인 성공 시 세션에 사용자 정보 저장
//			session.setAttribute("loggedInUser", user);
//			return "redirect:/works/list";
//		} else {
//			// 로그인 실패 시 처리
//			return "redirect:/login?error";
//		}
//	}

}
