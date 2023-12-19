package com.groupware.officehi.repository;

import java.util.List;

import com.groupware.officehi.dto.Work;

public interface WorkRepository {
	
	
	void arrivalTimeCheck();
	
	void leaveTimeCheck();
	
	List<Work> workTimes();
	
	
}
