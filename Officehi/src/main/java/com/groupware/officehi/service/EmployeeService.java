package com.groupware.officehi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public void insertUserInfo(EmployeeDTO employeeDTO) {
		employeeRepository.insert(employeeDTO);
	}

	public Optional<EmployeeDTO> findByUserNo(Long userNo) {
		return employeeRepository.findByUserNo(userNo);
	}

	public void updateUserInfo(EmployeeDTO employeeDTO) {
		employeeRepository.update(employeeDTO);

	}

	public void retiredUserInfo(Long userNo) {
		employeeRepository.updateFromDate(userNo);
	}

	public List<EmployeeDTO> findAllEmployee() {
		return employeeRepository.findAll();
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