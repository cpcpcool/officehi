package com.groupware.officehi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.WorkDTO;
import com.groupware.officehi.repository.WorkRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author 박재용
 * @editDate 23.12.19 ~23.12.22
 */

@Service
@RequiredArgsConstructor
public class WorkService {

	private final WorkRepository workRepository;

	public int arrivalTimeCheck(WorkDTO work) {
		return workRepository.insert(work);
	}

	public int leaveTimeCheck(WorkDTO work) {
		return workRepository.update(work);
	}

	public Integer checkDateDuplicte(Long userNo) {
		return workRepository.checkDateDuplicate(userNo);
	}

	public List<WorkDTO> findWorkTimesByUserNo(Long userNo) {
		return workRepository.findWorkTimeByUserNo(userNo);
	}

}
