package com.groupware.officehi.controller.user;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.dto.FileDTO;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.MyPageDTO;
import com.groupware.officehi.service.EmployeeService;
import com.groupware.officehi.service.MyPageService;

import lombok.RequiredArgsConstructor;

/**
 * @author 정유진
 * @editDate 23.12.19 ~ 23.12.20
 */
@Controller
@RequiredArgsConstructor
public class MyPageController {

	private final MyPageService myPageService;
	private final EmployeeService employeeService;

	@GetMapping("/mypage")
	public String myPageDetail(HttpServletRequest request, FileDTO fielDTO, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return "redirect:/login";

		LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return "redirect:/login";

		model.addAttribute("loginUser", loginUser);

		Optional<MyPageDTO> mypageuser = myPageService.findByUserNo(loginUser.getUserNo());
		if (mypageuser.get().getFromDate().equals("9999-01-01")) {
			mypageuser.get().setFromDate("-");
		}
		model.addAttribute("mypageuser", mypageuser.get());
		
		try {
			Optional<FileDTO> profile = employeeService.findProfileFileByUserNo(loginUser.getUserNo());
			model.addAttribute("profile", profile.get().getOriginalFileName());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("profile", "-");
		}
		try {
			Optional<FileDTO> stamp = employeeService.findStampFileByUserNo(loginUser.getUserNo());
			model.addAttribute("stamp", stamp.get().getOriginalFileName());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("stamp", "-");
		}

		return "user/myPage";
	}
}
