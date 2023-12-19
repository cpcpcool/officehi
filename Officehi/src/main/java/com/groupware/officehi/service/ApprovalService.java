package com.groupware.officehi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.repository.ApprovalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalService {
	private final ApprovalRepository repository;
	
	public void save(ApprovalDTO.ApprovalSaveDTO saveDTO) {
		repository.save(saveDTO);
	}
	
	public String findByUserNo(Long userNo) {
		return repository.findByUserNo(userNo);
	}
	
	public List<ApprovalDTO.ApprovalListDTO> approvalList() {
		return repository.findByUserIdApprovalList();
	}
	
	public List<ApprovalDTO.ApprovalUserList> findByUserNameAndDeptName() {
		return repository.findByUserNameAndDeptName();
	}
	
	public Optional<ApprovalDTO> findByApprovalNo(Long approvalNo) {
		return repository.findByApprovalNo(approvalNo);
	}
}
