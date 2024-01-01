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
	
	public String[] getPositionScope(String positionSearch) {
		String[] positionScope = {};

		switch(positionSearch) {
		case "대표":
			positionScope = new String[]{"사원", "주임", "대리", "팀장", "대표"};
			break;
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
		
		return positionScope;
	}
	
	public void insertApproval(ApprovalDTO approval) {
		repository.insert(approval);
	}
	
	public void insertChecker(ApprovalDTO.Checker insert) {
		repository.insertChecker(insert);
	};
	
	public String findUserByUserNo(Long userNo) {
		return repository.findUserByUserNo(userNo);
	}
	
	public List<ApprovalDTO> findAll(Paging paging) {
		return repository.findAll(paging);
	}
	
	public List<ApprovalDTO> findUserNameAndDeptName(Long userNo) {
		String positionSearch = employeeRepository.findUserInfoByUserNo(userNo).get().getPosition();
		
		String[] positionScope = getPositionScope(positionSearch);
		
		return repository.findUserNameAndDeptName(positionScope);
	}
	
	public List<ApprovalDTO> findUserNameAndDeptNameByApprovalNo(Long approvalNo, Long userNo) {
		String positionSearch = employeeRepository.findUserInfoByUserNo(userNo).get().getPosition();
		
		String[] positionScope = getPositionScope(positionSearch);
		
		return repository.findUserNameAndDeptNameByApprovalNo(approvalNo, positionScope);
	}

	public List<ApprovalDTO> findApprovalByUserNoOrChecker(Long userNo, Paging paging) {
		return repository.findApprovalByUserNoOrChecker(userNo, paging);
	}
	
	public List<ApprovalDTO> findAllByApprovalNo(Long approvalNo, Paging paging) {
		return repository.findAllByApprovalNo(approvalNo, paging);
	}
	
	public List<ApprovalDTO> findAllByUserNo(Long userNo, Paging paging) {
		return repository.findAllByUserNo(userNo, paging);
	}
	
	public List<ApprovalDTO> findAllByChecker(Long userNo, Paging paging) {
		return repository.findAllByChecker(userNo, paging);
	}
	
	public List<ApprovalDTO> findAllByUserName(String userName, Paging paging) {
		return repository.findAllByUserName(userName, paging);
	}
	
	public List<ApprovalDTO> findAllByTitle(String title, Paging paging) {
		return repository.findAllByTitle(title, paging);
	}
	
	public List<ApprovalDTO> findAllByDeptName(String deptName, Paging paging) {
		return repository.findAllByDeptName(deptName, paging);
	}
	
	public List<ApprovalDTO> findAllBydate(String date, Paging paging) {
		return repository.findAllBydate(date, paging);
	}
	
	public List<ApprovalDTO> findAllByCheckDate(String checkDate, Paging paging) {
		return repository.findAllByCheckDate(checkDate, paging);
	}	
	
	public List<ApprovalDTO.Checker> findChekcerByApprovalNo(Long approvalNo) {
		return repository.findChekcerByApprovalNo(approvalNo);
	};
	
	public Optional<ApprovalDTO> findByApprovalNo(Long approvalNo) {
		return repository.findByApprovalNo(approvalNo);
	}
	
	public void updateApproval(ApprovalDTO approval) {
		repository.updateApproval(approval);
	}
	
	public void updateChecker(ApprovalDTO.Checker checker) {
		repository.updateChecker(checker);
	};
	
	public void delete(Long approvalNo) {
		repository.delete(approvalNo);
	}
	
	public void deleteChecker(Long approvalNo, Integer checkerNo) {
		repository.deleteChecker(approvalNo, checkerNo);
	};
	
	public void updateStatus(ApprovalDTO approval) {
		repository.updateStatus(approval);
	}
}
