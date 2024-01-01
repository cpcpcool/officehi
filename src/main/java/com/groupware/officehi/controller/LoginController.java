package com.groupware.officehi.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.service.LoginService;

import lombok.RequiredArgsConstructor;

/**
* @author 이승준
* @editDate 23.12.18 ~ 23.12.20
*/

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final LoginService service;

	public class SessionConst {
		public static final String LOGIN_MEMBER = "loginMember";
	}

	@GetMapping
	public String loginIndex(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "redirect:/login";
		}
		LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return "redirect:/login";
		if (loginUser.getAdmin() == 1)
			return "redirect:/admin/employees";
		return "redirect:/main";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginUserDTO", new LoginUserDTO());
		return "index";
	}

	@PostMapping("/login")
	public String postLoginForm(@ModelAttribute LoginUserDTO loginUserDTO, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		Optional<LoginUserDTO> loginUser = service.findByUserNoAndPw(loginUserDTO.getUserNo(), loginUserDTO.getPw());
		if (!loginUser.isPresent()) {
			redirectAttributes.addFlashAttribute("duplicateMessage", "로그인 정보를 다시 확인해주세요.");
			return "redirect:/login";
		}
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginUser.get());
		if (loginUser.get().getAdmin() == 0) {
			return "redirect:/main";
		}
		return "redirect:/admin/employees";
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
