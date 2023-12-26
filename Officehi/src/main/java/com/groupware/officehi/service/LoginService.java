package com.groupware.officehi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.LoginUserDTO;
import com.groupware.officehi.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

/**
* @author 이승준
* @editDate 23.12.18 ~ 23.12.20
*/

@Service
@RequiredArgsConstructor
public class LoginService {
	private final LoginRepository repository;
	
	public Optional<LoginUserDTO> findByUserNoAndPw(Long userNo, String pw) {
		return repository.findByUserNoAndPw(userNo, pw);
	}
}
