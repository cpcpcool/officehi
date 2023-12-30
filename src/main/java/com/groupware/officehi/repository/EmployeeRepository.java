package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.dto.FileDTO;

/**
 * @author 박재용
 * @editDate 23.12.20 ~ 23.12.22
 * 페이지네이션 기능 추가 23.12.24 ~ 23.12.25
 * 파일 업로드 및 수정 기능 추가 23.12.26 ~ 23.12.29 
 */

@Repository
public interface EmployeeRepository {

	void insert(EmployeeDTO employeeDTO);
	void insertFileInfo(FileDTO fileDTO);

	String getFilePathByFileTypeNo(@Param("fileTypeNo") String fileTypeNo);
	
	Optional<EmployeeDTO> findUserInfoByUserNo(@Param("userNo") Long userNo);

	Optional<FileDTO> findProfileFileByUserNo(@Param("userNo") Long userNo);
	Optional<FileDTO> findStampFileByUserNo(@Param("userNo") Long userNo);

	void update(EmployeeDTO employeeDTO);
	void updateFileInfo(FileDTO fileDTO);

	void updateFromDate(@Param("userNo") Long userNo);

	List<EmployeeDTO> findAll(@Param("paging") Paging paging);
	List<EmployeeDTO> findAllByName(@Param("name") String name, @Param("paging") Paging paging);
	List<EmployeeDTO> findAllByUserNo(@Param("userNo") Long userNo, @Param("paging") Paging paging);
	List<EmployeeDTO> findAllByDeptName(@Param("deptName") String deptName, @Param("paging") Paging paging);

}