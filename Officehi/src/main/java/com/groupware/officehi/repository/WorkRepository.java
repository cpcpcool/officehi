package com.groupware.officehi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.dto.WorkDTO;

@Repository
public interface WorkRepository {

	void insert(WorkDTO work);

	void update(WorkDTO work);

	Integer checkDateDuplicate(Long userNo);

	List<WorkDTO> findWorkTimeByUserNo(@Param("userNo") Long userNo);
}
