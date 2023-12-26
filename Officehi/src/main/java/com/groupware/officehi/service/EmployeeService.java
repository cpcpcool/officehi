package com.groupware.officehi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author 박재용
 * @editDate 23.12.20 ~ 23.12.22
 * 페이지네이션 기능 추가 23.12.23 ~ 23.12.25
 */

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

	public List<EmployeeDTO> findAllPagingEmployee(Paging paging) {
		return employeeRepository.findAllPaging(paging);
	}

	public List<EmployeeDTO> searchUserName(String name, Paging paging) {
		return employeeRepository.searchUserName(name, paging);
	}

	public List<EmployeeDTO> searchUserNo(Long userNo) {
		return employeeRepository.searchUserNo(userNo);
	}

	public List<EmployeeDTO> searchDeptName(String deptName) {
		return employeeRepository.searchDeptName(deptName);
	}

}