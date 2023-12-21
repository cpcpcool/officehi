package com.groupware.officehi.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.groupware.officehi.dto.LoginUserDTO;

@Mapper
public interface LoginRepository {
	Optional<LoginUserDTO> findByUserNoAndPw(@Param("userNo") Long userNo,@Param("pw") String pw);
}
