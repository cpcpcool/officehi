package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.groupware.officehi.dto.ApprovalDTO;

@Mapper
public interface ApprovalRepository {
	void insert(ApprovalDTO insert);
	List<ApprovalDTO> findAll();

	String findUserByUserNo(Long userNo);

	List<ApprovalDTO> findApprovalByUserNo(Long userNo);
	List<ApprovalDTO> findUserNameAndDeptName();
	List<ApprovalDTO> findUserNameAndDeptNameByApprovalNo(Long approvalNo);
	Optional<ApprovalDTO> findByApprovalNo(Long approvalNo);
	void updateApproval(ApprovalDTO update);
	void delete(Long ApprovalNo);
	void updateStatus(ApprovalDTO status);
}
