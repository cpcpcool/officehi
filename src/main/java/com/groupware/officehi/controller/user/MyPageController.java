package com.groupware.officehi.controller.user;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public LoginUserDTO loginUser = null;

	public boolean loginCheck(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null)
			return true;

		this.loginUser = (LoginUserDTO) session.getAttribute(SessionConst.LOGIN_MEMBER);
		if (loginUser == null)
			return true;

		model.addAttribute("loginUser", loginUser);

		return false;
	}

	@GetMapping("/mypage")
	public String myPageDetail(FileDTO fielDTO, Model model, HttpServletRequest request) {
		if (loginCheck(request, model))
			return "redirect:/login";

		Optional<MyPageDTO> mypageuser = myPageService.findByUserNo(loginUser.getUserNo());
		if (mypageuser.get().getFromDate().equals("9999-01-01")) {
			mypageuser.get().setFromDate("-");
		}
		model.addAttribute("mypageuser", mypageuser.get());

		Optional<FileDTO> profileFile = employeeService.findProfileFileByUserNo(loginUser.getUserNo());
		if (profileFile.isPresent())
			model.addAttribute("profileFile", profileFile.get());
		else
			model.addAttribute("profileFile", profileFile.orElse(new FileDTO("-")));

		Optional<FileDTO> stampFile = employeeService.findStampFileByUserNo(loginUser.getUserNo());
		if (stampFile.isPresent())
			model.addAttribute("stampFile", stampFile.get());
		else
			model.addAttribute("stampFile", stampFile.orElse(new FileDTO("-")));

		return "user/myPage";
	}

	@PostMapping("/myPage")
	public String editMyFiles(EmployeeDTO employeeDTO, FileDTO fielDTO,
			@RequestParam("profile") MultipartFile profileMultipartFile,
			@RequestParam("stamp") MultipartFile stampMultipartFile, Model model, HttpServletRequest request) {
		if (loginCheck(request, model))
			return "redirect:/login";

		// 이미지파일 변경 로직
		FileDTO fileDTO = new FileDTO();
		fileDTO.setUserNo(loginUser.getUserNo());
		
		Optional<FileDTO> profileFile = employeeService.findProfileFileByUserNo(loginUser.getUserNo());
		Optional<FileDTO> stampFile = employeeService.findStampFileByUserNo(loginUser.getUserNo());

		if(profileFile.isEmpty()) {
			// profile 증명사진 최초등록
			fileDTO.setMultipartFile(profileMultipartFile);
			fileDTO.setFileTypeNo("1");
			employeeService.insertFileInfo(fileDTO);			
		}else {
			// profile 증명사진 변경저장
			fileDTO.setMultipartFile(profileMultipartFile);
			fileDTO.setFileTypeNo("1");
			employeeService.updateFileInfo(fileDTO);
		}
		if(stampFile.isEmpty()) {
			fileDTO.setMultipartFile(stampMultipartFile);
			fileDTO.setFileTypeNo("2");
			employeeService.insertFileInfo(fileDTO); 
		}else {
			fileDTO.setMultipartFile(stampMultipartFile);
			fileDTO.setFileTypeNo("2");
			employeeService.updateFileInfo(fileDTO); 
		}
		employeeService.updateUserInfo(employeeDTO);

		return "redirect:/mypage";
	}
}
