package com.groupware.officehi.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;

import com.groupware.officehi.dto.LoginUserDTO;

/**
* @author 이승준
* @editDate 23.12.18 ~ 23.12.20
*/

public interface LoginRepository {
	Optional<LoginUserDTO> findByUserNoAndPw(@Param("userNo") Long userNo,@Param("pw") String pw);
}
