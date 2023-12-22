package com.groupware.officehi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.WorkDTO;
import com.groupware.officehi.repository.WorkRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WorkService {

	private final WorkRepository workRepository;

	@Autowired
	private WorkService(WorkRepository workRepository) {
		this.workRepository = workRepository;
		log.info("서비스실행됨");
	}

	public void arrivalTimeCheck(WorkDTO work) {
		workRepository.arrivalTimeCheck(work);
	}

	public void leaveTimeCheck(WorkDTO work) {
		workRepository.leaveTimeCheck(work);
	}

	public Integer checkDateDuplicte(Long userNo) {
		return workRepository.checkDateDuplicte(userNo);
	}

	public List<WorkDTO> workTimesByUserNo(Long userNo) {
		return workRepository.workTimesByUserNo(userNo);
	}

}
