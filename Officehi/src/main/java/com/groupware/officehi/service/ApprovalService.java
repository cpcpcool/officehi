package com.groupware.officehi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.repository.ApprovalRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author 엄다빈
 * @editDate 23.12.18 ~23.12.26
 */

@Service
@RequiredArgsConstructor
public class ApprovalService {
	private final ApprovalRepository repository;
	
	public void insertApproval(ApprovalDTO approval) {
		repository.insert(approval);
	}
	
	public String findUserByUserNo(Long userNo) {
		return repository.findUserByUserNo(userNo);
	}
	
	public List<ApprovalDTO> findApproval() {
		return repository.findApproval();
	}
	
	public List<ApprovalDTO> findAllUserNameAndDeptName(Long userNo) {
		return repository.findUserNameAndDeptName(userNo);
	}
	
	public List<ApprovalDTO> findAllUserNameAndDeptNameByApprovalNo(Long approvalNo) {
		return repository.findUserNameAndDeptNameByApprovalNo(approvalNo);
	}
	
	public Optional<ApprovalDTO> findByApprovalNo(Long approvalNo) {
		return repository.findByApprovalNo(approvalNo);
	}
	
	public void updateApproval(ApprovalDTO approval) {
		repository.updateApproval(approval);
	}
	
	public void delete(Long approvalNo) {
		repository.delete(approvalNo);
	}
	
	public void updateStatus(ApprovalDTO approval) {
		repository.updateStatus(approval);
	}
	
	public List<ApprovalDTO> findApprovalByUserNoOrChecker(Long userNo) {
		return repository.findApprovalByUserNoOrChecker(userNo);
	}
	
	public List<ApprovalDTO> findApprovalByUserNo(Long userNo) {
		return repository.findApprovalByUserNo(userNo);
	}
	
	public List<ApprovalDTO> findApprovalByChecker(Long userNo) {
		return repository.findApprovalByChecker(userNo);
	}
	
	public List<ApprovalDTO> findApprovalByApprovalNo(Long approvalNo) {
		return repository.findApprovalByApprovalNo(approvalNo);
	}
	
	public List<ApprovalDTO> findApprovalByUserName(String userName) {
		return repository.findApprovalByUserName(userName);
	}
	
	public List<ApprovalDTO> findApprovalByTitle(String title) {
		return repository.findApprovalByTitle(title);
	}
	
	public List<ApprovalDTO> findApprovalByDeptName(String deptName) {
		return repository.findApprovalByDeptName(deptName);
	}
	
	public List<ApprovalDTO> findApprovalBydate(String date) {
		return repository.findApprovalBydate(date);
	}
	
	public List<ApprovalDTO> findApprovalByCheckDate(String checkDate) {
		return repository.findApprovalByCheckDate(checkDate);
	}
}
