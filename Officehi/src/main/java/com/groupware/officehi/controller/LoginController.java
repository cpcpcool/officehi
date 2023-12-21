package com.groupware.officehi.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.service.LoginService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
	private final LoginService service;
	
	public class SessionConst {
	    public static final String LOGIN_MEMBER = "loginMember";
	}
	
	@GetMapping("")
	public String loginIndex(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		// 로그인 세션이 없을 때 로그인 페이지로 이동
		if(session == null) {
			return "redirect:/login";
		}
		LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		// 로그인 세션의 유저가 관리자일 때 관리자 메인 페이지로 이동
		if(loginUser.getAdmin() == 1)
			return "redirect:/admin/employees";
		// 로그인 세션의 유저가 사용자일 때 사용자 메인 페이지로 이동
		return "redirect:/main";
	}
	
	@GetMapping("/login")
	public String login() {
		return "index";
	}
	
	@PostMapping("/login")
	public String postLoginForm(Long userNo, String pw, HttpServletRequest request) {
		Optional<LoginUserDTO> loginUser = service.findByUserNoAndPw(userNo, pw);
		// 쿼리문 실행으로 가져온 객체가 없다면 로그인 화면으로 다시 리다이렉트, 있다면 로그인 성공 처리
		if(!loginUser.isPresent()) {
			return "redirect:/login";
		} 
		HttpSession session = request.getSession();
	    // 로그인에 성공한 로그인유저 객체로 세션에 로그인 회원 정보 보관
	    session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser.get());
	    // 로그인유저 객체의 admin 변수로 관리자와 사용자를 구분해 그에 맞는 뷰를 반환
		if(loginUser.get().getAdmin()==0) {
			return "redirect:/main";
		}
		return "redirect:/admin/employees";
	}
	
	@GetMapping("/main")
	public String main(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/login";
        }
        LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
        model.addAttribute("loginUser",loginUser);
		return "/user/main";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }
	    return "redirect:/login";
	}
}
