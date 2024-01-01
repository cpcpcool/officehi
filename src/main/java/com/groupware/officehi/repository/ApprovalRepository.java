package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.ApprovalDTO;

/**
 * @author 엄다빈
 * @editDate 23.12.18 ~ 23.12.26
 */

@Repository
public interface ApprovalRepository {
	
	void insert(ApprovalDTO insert);
	void insertChecker(ApprovalDTO.Checker insert);
	String findUserByUserNo(Long userNo);

	List<ApprovalDTO> findAll(@Param(value = "paging")Paging paging);
	List<ApprovalDTO> findApprovalByUserNoOrChecker(@Param(value = "userNo") Long userNo, @Param(value = "paging") Paging paging);
	
	List<ApprovalDTO> findUserNameAndDeptName(String[] position);
	List<ApprovalDTO> findUserNameAndDeptNameByApprovalNo(@Param(value = "approvalNo") Long approvalNo, @Param(value = "position") String[] position);
	
	List<ApprovalDTO> findAllByApprovalNo(@Param(value = "approvalNo") Long approvalNo, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByUserNo(@Param(value = "userNo") Long userNo, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByChecker(@Param(value = "userNo") Long userNo, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByUserName(@Param(value = "userName") String userName, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByTitle(@Param(value = "title") String title, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByDeptName(@Param(value = "deptName") String deptName, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllBydate(@Param(value = "date") String date, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByCheckDate(@Param(value = "checkDate") String checkDate, @Param(value = "paging") Paging paging);
	
	List<ApprovalDTO.Checker> findChekcerByApprovalNo(Long approvalNo);
	
	Optional<ApprovalDTO> findByApprovalNo(Long approvalNo);
	void updateApproval(ApprovalDTO approval);
	void updateChecker(ApprovalDTO.Checker checker);
	void delete(Long ApprovalNo);
	void deleteChecker(@Param(value = "approvalNo") Long approvalNo, @Param(value = "checkerNo") Integer checkerNo);
	void updateStatus(ApprovalDTO approval);
}