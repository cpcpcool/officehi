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
	
	public void insertApproval(ApprovalDTO insert) {
		repository.insertApproval(insert);
	}
	
	public String findUserByUserNo(Long userNo) {
		return repository.findUserByUserNo(userNo);
	}
	
	public List<ApprovalDTO> findAllApproval() {
		return repository.findAllApproval();
	}
	
	public List<ApprovalDTO> findAllUserNameAndDeptName() {
		return repository.findAllUserNameAndDeptName();
	}
	
	public Optional<ApprovalDTO> findByApprovalNo(Long approvalNo) {
		return repository.findByApprovalNo(approvalNo);
	}
	
	public void updateApproval(ApprovalDTO update) {
		repository.updateApproval(update);
	}
	
	public void updateApproval(Long approvalNo) {
		repository.deleteApproval(approvalNo);
	}
	
	public void updateStatus(ApprovalDTO status) {
		repository.updateStatus(status);
	}
	
	public List<ApprovalDTO> findAllApprovalByUserNo(Long userNo) {
		return repository.findAllApprovalByUserNo(userNo);
	}
}
