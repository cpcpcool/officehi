package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.groupware.officehi.dto.ApprovalDTO;

@Mapper
public interface ApprovalRepository {
	void insertApproval(ApprovalDTO insert);
	String findUserByUserNo(Long userNo);
	List<ApprovalDTO> findAllApproval();
	List<ApprovalDTO> findAllApprovalByUserNo(Long userNo);
	List<ApprovalDTO> findAllUserNameAndDeptName();
	List<ApprovalDTO> findAllUserNameAndDeptNameByApprovalNo(Long approvalNo);
	Optional<ApprovalDTO> findByApprovalNo(Long approvalNo);
	void updateApproval(ApprovalDTO update);
	void deleteApproval(Long ApprovalNo);
	void updateStatus(ApprovalDTO status);
}
