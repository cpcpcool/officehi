package com.groupware.officehi.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.dto.MyPageDTO;

@Repository
public interface MyPageRepository {
	Optional<MyPageDTO> findByUserNo(@Param("userNo") Long userNo);
}
