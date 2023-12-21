package com.groupware.officehi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.groupware.officehi.dto.EmployeeDTO;

@Repository
public interface EmployeeRepository {

	void saveUserInfo(EmployeeDTO employeeDTO);

	Optional<EmployeeDTO> findByUserNo(@Param("userNo") Long userNo);

	void updateUserInfo(EmployeeDTO employeeDTO);

	void retiredUserInfo(@Param("userNo") Long userNo);

	List<EmployeeDTO> findAllEmployee();

	List<EmployeeDTO> searchUserName(@Param("name") String name);
	List<EmployeeDTO> searchUserNo(@Param("userNo") Long userNo);
	List<EmployeeDTO> searchDeptName(@Param("deptName") String deptName);

}
