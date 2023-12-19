package com.groupware.officehi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.groupware.officehi.dto.Work;

@Repository
public interface WorkRepository {
	
	
//	void arrivalTimeCheck();
//	
//	void leaveTimeCheck();
	
	List<Work> workTimes();
	
	
}
