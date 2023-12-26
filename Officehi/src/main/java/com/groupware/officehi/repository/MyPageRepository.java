package com.groupware.officehi.repository;
/**
 * @author 정유진
 * @editDate 23.12.18 ~23.12.26
 */
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.dto.MyPageDTO;

@Repository
public interface MyPageRepository {
	Optional<MyPageDTO> findByUserNo(@Param("userNo") Long userNo);
}
