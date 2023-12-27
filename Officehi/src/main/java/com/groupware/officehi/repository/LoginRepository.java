package com.groupware.officehi.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.dto.LoginUserDTO;

/**
* @author 이승준
* @editDate 23.12.18 ~ 23.12.20
* 
* 사원등록 시 로그인 권한 부여로직 추가
* @author 박재용
* @editDate 23.12.26 ~ 23.12.27
*/

@Repository
public interface LoginRepository {
	Optional<LoginUserDTO> findByUserNoAndPw(@Param("userNo") Long userNo, @Param("pw") String pw);
	
	int saveUserInfo(@Param("userNo") Long userNo);
}