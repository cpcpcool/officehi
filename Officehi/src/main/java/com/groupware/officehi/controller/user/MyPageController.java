package com.groupware.officehi.controller.user;
/**
 * @author 정유진
 * @editDate 23.12.18 ~23.12.26
 */
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.groupware.officehi.controller.LoginController.SessionConst;
import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.dto.MyPageDTO;
import com.groupware.officehi.service.MyPageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class MyPageController {

	private final MyPageService myPageService;

	@GetMapping("/mypage")
	public String myPageDetail(HttpServletRequest request, Long userNo, Model model) {
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
		return "user/myPage";
	}
}
