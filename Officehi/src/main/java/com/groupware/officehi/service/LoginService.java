package com.groupware.officehi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

/**
* @author 이승준
* @editDate 23.12.18 ~ 23.12.20
* 
* 사원등록 시 로그인 권한 부여로직 추가
* @author 박재용
* @editDate 23.12.26 ~ 23.12.27
*/

@Service
@RequiredArgsConstructor
public class LoginService {
	private final LoginRepository loginRepository;
	
	public Optional<LoginUserDTO> findByUserNoAndPw(Long userNo, String pw) {
		return loginRepository.findByUserNoAndPw(userNo, pw);
	}
	
	public int saveUserInfo(Long userNo) {
		return loginRepository.saveUserInfo(userNo);
	}
	
}
