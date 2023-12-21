package com.groupware.officehi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.dto.WorkDTO;

@Repository
public interface WorkRepository {
	
	void arrivalTimeCheck(WorkDTO work);
	
	void leaveTimeCheck(WorkDTO work);

	Integer checkDateDuplicte(Long userNo);
	
	List<WorkDTO> workTimesByUserNo(@Param("userNo") Long userNo);

	// 전체 조회용
	List<WorkDTO> workTimes();
}
