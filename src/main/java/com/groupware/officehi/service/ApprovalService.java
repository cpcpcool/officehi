package com.groupware.officehi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.ApprovalDTO;
import com.groupware.officehi.repository.ApprovalRepository;
import com.groupware.officehi.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author 엄다빈
 * @editDate 23.12.18 ~ 23.12.26
 */

@Service
@RequiredArgsConstructor
public class ApprovalService {
	
	private final ApprovalRepository repository;
	private final EmployeeRepository employeeRepository;
	
	public void insertApproval(ApprovalDTO approval) {
		repository.insert(approval);
	}
	
	public String findUserByUserNo(Long userNo) {
		return repository.findUserByUserNo(userNo);
	}
	
	public List<ApprovalDTO> findAll() {
		return repository.findAll();
	}
	
	public List<ApprovalDTO> findUserNameAndDeptName(Long userNo) {
		String positionSearch = employeeRepository.findUserInfoByUserNo(userNo).get().getPosition();
		String[] positionScope = {};
		
		switch(positionSearch) {
		case "팀장":
			positionScope = new String[]{"사원", "주임", "대리", "팀장"};
			break;
		case "대리":
			positionScope = new String[]{"사원", "주임", "대리"};
			break;
		case "주임":
			positionScope = new String[]{"사원", "주임"};
			break;
		case "사원":
			positionScope = new String[]{"사원"};
			break;
		}
		
		return repository.findUserNameAndDeptName(positionScope);
	}
	
	public List<ApprovalDTO> findUserNameAndDeptNameByApprovalNo(Long approvalNo, Long userNo) {
		return repository.findUserNameAndDeptNameByApprovalNo(approvalNo, userNo);
	}

	public List<ApprovalDTO> findApprovalByUserNoOrChecker(Long userNo) {
		return repository.findApprovalByUserNoOrChecker(userNo);
	}
	
	public List<ApprovalDTO> findAllByApprovalNo(Long approvalNo) {
		return repository.findAllByApprovalNo(approvalNo);
	}
	
	public List<ApprovalDTO> findAllByUserNo(Long userNo) {
		return repository.findAllByUserNo(userNo);
	}
	
	public List<ApprovalDTO> findAllByChecker(Long userNo) {
		return repository.findAllByChecker(userNo);
	}
	
	public List<ApprovalDTO> findAllByUserName(String userName) {
		return repository.findAllByUserName(userName);
	}
	
	public List<ApprovalDTO> findAllByTitle(String title) {
		return repository.findAllByTitle(title);
	}
	
	public List<ApprovalDTO> findAllByDeptName(String deptName) {
		return repository.findAllByDeptName(deptName);
	}
	
	public List<ApprovalDTO> findAllBydate(String date) {
		return repository.findAllBydate(date);
	}
	
	public List<ApprovalDTO> findAllByCheckDate(String checkDate) {
		return repository.findAllByCheckDate(checkDate);
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
	
	// paging query
	public List<ApprovalDTO> findAllPaging(Paging paging) {
		return repository.findAllPaging(paging);
	}
	
	public List<ApprovalDTO> findApprovalByUserNoOrCheckerPaging(Long userNo, Paging paging) {
		return repository.findApprovalByUserNoOrCheckerPaging(userNo, paging);
	}
	
	public List<ApprovalDTO> findAllByApprovalNoPaging(Long approvalNo, Paging paging) {
		return repository.findAllByApprovalNoPaging(approvalNo, paging);
	}
	
	public List<ApprovalDTO> findAllByUserNoPaging(Long userNo, Paging paging) {
		return repository.findAllByUserNoPaging(userNo, paging);
	}
	
	public List<ApprovalDTO> findAllByCheckerPaging(Long userNo, Paging paging) {
		return repository.findAllByCheckerPaging(userNo, paging);
	}
	
	public List<ApprovalDTO> findAllByUserNamePaging(String userName, Paging paging) {
		return repository.findAllByUserNamePaging(userName, paging);
	}
	
	public List<ApprovalDTO> findAllByTitlePaging(String title, Paging paging) {
		return repository.findAllByTitlePaging(title, paging);
	}
	
	public List<ApprovalDTO> findAllByDeptNamePaging(String deptName, Paging paging) {
		return repository.findAllByDeptNamePaging(deptName, paging);
	}
	
	public List<ApprovalDTO> findAllBydatePaging(String date, Paging paging) {
		return repository.findAllBydatePaging(date, paging);
	}
	
	public List<ApprovalDTO> findAllByCheckDatePaging(String checkDate, Paging paging) {
		return repository.findAllByCheckDatePaging(checkDate, paging);
	}
}
