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

	void updateFromDate(@Param("userNo") Long userNo);

	List<EmployeeDTO> findAll();
	List<EmployeeDTO> findAllByName(@Param("name") String name);
	List<EmployeeDTO> findAllByUserNo(@Param("userNo") Long userNo);
	List<EmployeeDTO> findAllByDeptName(@Param("deptName") String deptName);

	// paging search
	List<EmployeeDTO> findAllPaging(Paging paging);
	List<EmployeeDTO> findAllByNamePaging(@Param("name") String name, @Param("paging") Paging paging);
	List<EmployeeDTO> findAllByUserNoPaging(@Param("userNo") Long userNo, @Param("paging") Paging paging);
	List<EmployeeDTO> findAllByDeptNamePaging(@Param("deptName") String deptName, @Param("paging") Paging paging);
	
}
