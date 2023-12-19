package com.groupware.officehi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.groupware.officehi.dto.ApprovalDTO;

@Mapper
public interface ApprovalRepository {
	void save(ApprovalDTO.ApprovalSaveDTO saveDTO);
	List<ApprovalDTO.ApprovalListDTO> findByUserIdApprovalList();
	List<ApprovalDTO.ApprovalUserList> findByUserNameAndDeptName();
}
