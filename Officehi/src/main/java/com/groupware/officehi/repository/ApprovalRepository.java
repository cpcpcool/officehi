package com.groupware.officehi.repository;

/**
 * @author 엄다빈
 * @editDate 23.12.18 ~23.12.26
 */

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.groupware.officehi.dto.ApprovalDTO;

@Mapper
public interface ApprovalRepository {
	void insert(ApprovalDTO insert);

	String findUserByUserNo(Long userNo);

	List<ApprovalDTO> findApproval();
	List<ApprovalDTO> findApprovalByUserNoOrChercker(Long userNo);
	List<ApprovalDTO> findUserNameAndDeptName(Long userNo);
	List<ApprovalDTO> findUserNameAndDeptNameByApprovalNo(Long approvalNo);
	List<ApprovalDTO> findApprovalByUserNo(Long userNo);
	List<ApprovalDTO> findApprovalByChecker(Long userNo);
	
	List<ApprovalDTO> findApprovalByApprovalNo(Long approvalNo);
	List<ApprovalDTO> findApprovalByTitle(String title);
	List<ApprovalDTO> findApprovalByDeptName(String deptName);
	List<ApprovalDTO> findApprovalBydate(String date);
	List<ApprovalDTO> findApprovalByCheckDate(String checkDate);
	
	Optional<ApprovalDTO> findByApprovalNo(Long approvalNo);
	void updateApproval(ApprovalDTO approval);
	void delete(Long ApprovalNo);
	void updateStatus(ApprovalDTO approval);
}
