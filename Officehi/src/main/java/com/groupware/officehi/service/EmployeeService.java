package com.groupware.officehi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public void saveUserInfo(EmployeeDTO employeeDTO) {
		employeeRepository.saveUserInfo(employeeDTO);
	}

	public Optional<EmployeeDTO> findByUserNo(Long userNo) {
		return employeeRepository.findByUserNo(userNo);
	}

	public void updateUserInfo(EmployeeDTO employeeDTO) {
		employeeRepository.updateUserInfo(employeeDTO); 
		
	}

	public void retiredUserInfo(Long userNo) {
		employeeRepository.retiredUserInfo(userNo);
	}

	public List<EmployeeDTO> findAllEmployee() {
		return employeeRepository.findAllEmployee();
	}
	
	public List<EmployeeDTO> searchUserName(String name) {
		return employeeRepository.searchUserName(name);
	}
	public List<EmployeeDTO> searchUserNo(Long userNo) {
		return employeeRepository.searchUserNo(userNo);
	}
	public List<EmployeeDTO> searchDeptName(String deptName) {
		return employeeRepository.searchDeptName(deptName);
	}
	
}
