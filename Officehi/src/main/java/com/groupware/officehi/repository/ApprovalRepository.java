package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.groupware.officehi.dto.ApprovalDTO;

@Mapper
public interface ApprovalRepository {
	void save(ApprovalDTO.ApprovalSaveDTO saveDTO);
	String findByUserNo(Long userNo);
	List<ApprovalDTO.ApprovalListDTO> findByUserIdApprovalList();
	List<ApprovalDTO.ApprovalUserList> findByUserNameAndDeptName();
	Optional<ApprovalDTO> findByApprovalNo(Long approvalNo);
}
