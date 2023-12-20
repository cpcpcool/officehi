package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;

import com.groupware.officehi.dto.EmployeeDTO;

public interface EmployeeRepository {

	void saveUserInfo(EmployeeDTO employeeDTO);
		
	Optional<EmployeeDTO> findByUserNo(@Param("userNo") Long userNo);
	
//	void updateUserInfo(@Param("userNo") Long userNo);
	
	List<EmployeeDTO> findAllEmployee();
	
	
}
