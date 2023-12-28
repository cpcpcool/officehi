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
	String findUserByUserNo(Long userNo);

	List<ApprovalDTO> findAll();
	List<ApprovalDTO> findApprovalByUserNoOrChecker(Long userNo);
	
	List<ApprovalDTO> findUserNameAndDeptName(String[] position);
	List<ApprovalDTO> findUserNameAndDeptNameByApprovalNo(@Param(value = "approvalNo") Long approvalNo, @Param(value = "userNo") Long userNo);
	
	List<ApprovalDTO> findAllByApprovalNo(Long approvalNo);
	List<ApprovalDTO> findAllByUserNo(Long userNo);
	List<ApprovalDTO> findAllByChecker(Long userNo);
	List<ApprovalDTO> findAllByUserName(String userName);
	List<ApprovalDTO> findAllByTitle(String title);
	List<ApprovalDTO> findAllByDeptName(String deptName);
	List<ApprovalDTO> findAllBydate(String date);
	List<ApprovalDTO> findAllByCheckDate(String checkDate);
	
	Optional<ApprovalDTO> findByApprovalNo(Long approvalNo);
	void updateApproval(ApprovalDTO approval);
	void delete(Long ApprovalNo);
	void updateStatus(ApprovalDTO approval);
	
	// paging query
	List<ApprovalDTO> findAllPaging(Paging paging);
	List<ApprovalDTO> findApprovalByUserNoOrCheckerPaging(@Param(value = "userNo") Long userNo, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByApprovalNoPaging(@Param(value = "approvalNo") Long approvalNo, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByUserNoPaging(@Param(value = "userNo") Long userNo, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByCheckerPaging(@Param(value = "userNo") Long userNo, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByUserNamePaging(@Param(value = "userName") String userName, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByTitlePaging(@Param(value = "title") String title, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByDeptNamePaging(@Param(value = "deptName") String deptName, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllBydatePaging(@Param(value = "date") String date, @Param(value = "paging") Paging paging);
	List<ApprovalDTO> findAllByCheckDatePaging(@Param(value = "checkDate") String checkDate, @Param(value = "paging") Paging paging);
}
