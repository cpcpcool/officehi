package com.groupware.officehi.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String postLoginForm(String userNo, String pw, HttpServletRequest request) {
		Optional<LoginUserDTO> loginUser = service.findByUserNoAndPw(Long.parseLong(userNo), pw);
		if(!loginUser.isPresent())
			return "redirect:/login";
		//로그인 성공 처리
		HttpSession session = request.getSession();
	    //세션에 로그인 회원 정보 보관
	    session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser.get());

		
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
	
	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }
	    return "redirect:/login";
	}
	
	@GetMapping("/session-info")
	@ResponseBody
    public String sessionInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "no session";
        }
        // 세션 id와 저장된 객체 정보 출력
        System.out.println(session.getId() + ", " + session.getAttribute("loginMember"));

        //세션 데이터 출력
//        session.getAttributeNames().asIterator()
//                .forEachRemaining(name -> log.info("session name={}, value={}", name, session.getAttribute(name)));

        log.info("sessionId={}", session.getId());
        log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
        log.info("creationTime={}", new Date(session.getCreationTime()));
        log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));
        log.info("isNew={}", session.isNew());

        return "yes session";

    }
}
