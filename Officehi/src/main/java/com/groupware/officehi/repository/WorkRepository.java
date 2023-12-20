package com.groupware.officehi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.dto.Work;

@Repository
public interface WorkRepository {
	
	void arrivalTimeCheck(Work work);
	
	void leaveTimeCheck(Work work);

	Integer checkDateDuplicte(Long userNo);
	
//	int checkLeaveTime(Long userNo);
	
	
	List<Work> workTimesByUserNo(@Param("userNo") Long userNo);

	// 전체 조회용
	List<Work> workTimes();
}
