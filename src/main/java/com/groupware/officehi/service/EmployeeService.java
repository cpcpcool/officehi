package com.groupware.officehi.service;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.officehi.domain.Paging;
import com.groupware.officehi.dto.EmployeeDTO;
import com.groupware.officehi.dto.FileDTO;
import com.groupware.officehi.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 박재용
 * @editDate 23.12.20 ~ 23.12.22 페이지네이션 기능 추가 23.12.23 ~ 23.12.25 파일 업로드 및 수정
 *           비즈니스로직 추가 23.12.26 ~ 23.12.29
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final ServletContext servletContext;

	public void insertUserInfo(EmployeeDTO employeeDTO) {
		employeeRepository.insert(employeeDTO);
	}

	public void insertFileInfo(FileDTO fileDTO) {
		MultipartFile multipartFile = fileDTO.getMultipartFile();
		String externalDir = "./storage";
		String currentTime = Long.toString(System.currentTimeMillis());
		
		String externalFilePath = externalDir
				+ employeeRepository.getFilePathByFileTypeNo(fileDTO.getFileTypeNo());
		log.info("fileForLoad : {}", externalDir);
		
//		String realFilePath = servletContext.getRealPath("/")
//				+ employeeRepository.getFilePathByFileTypeNo(fileDTO.getFileTypeNo());

//		String filePath = System.getProperty("user.dir") + "/"
//				+ employeeRepository.getFilePathByFileTypeNo(fileDTO.getFileTypeNo());
		String originalFileName = multipartFile.getOriginalFilename();
		String convertFileName = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + "_" + currentTime
				+ originalFileName.substring(originalFileName.lastIndexOf("."));

		// OS 별 구분자 교체
		externalFilePath = externalFilePath.replace("/", File.separator).replace("\\", File.separator);

		File fileForLoad = new File(externalFilePath, convertFileName);
		log.info("fileForLoad : {}", fileForLoad);
//		File file = new File(filePath, convertFileName);
//		log.info("file : {}", file);

		// try catch로 예외 처리 안해줄 시 컴퓨터가 어떻게 할지 몰라서 필수로 해주기
		try {
			// file 물리저장
			multipartFile.transferTo(fileForLoad);
//			multipartFile.transferTo(file);

			// filePath DB 저장
			fileDTO.setFileName(convertFileName);
			fileDTO.setOriginalFileName(originalFileName);
			fileDTO.setFilePath(externalFilePath);

			employeeRepository.insertFileInfo(fileDTO);
		} catch (Exception e) {
			log.error("File upload failed: {}", e.getMessage());
			e.printStackTrace();
		}
	}

	public Optional<EmployeeDTO> findUserInfoByUserNo(Long userNo) {
		return employeeRepository.findUserInfoByUserNo(userNo);
	}

	public Optional<FileDTO> findProfileFileByUserNo(Long userNo) {
		return employeeRepository.findProfileFileByUserNo(userNo);
	}

	public Optional<FileDTO> findStampFileByUserNo(Long userNo) {
		return employeeRepository.findStampFileByUserNo(userNo);
	}

	public void updateUserInfo(EmployeeDTO employeeDTO) {
		employeeRepository.update(employeeDTO);

	}

	public void updateFileInfo(FileDTO fileDTO) {
		MultipartFile multipartFile = fileDTO.getMultipartFile();

		String currentTime = Long.toString(System.currentTimeMillis());
		String filePath = System.getProperty("user.dir")
				+ employeeRepository.getFilePathByFileTypeNo(fileDTO.getFileTypeNo());
		String originalFileName = multipartFile.getOriginalFilename();
		String convertFileName = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + "_" + currentTime
				+ originalFileName.substring(originalFileName.lastIndexOf("."));

		// OS 별 구분자 교체

		filePath = filePath.replace("\\", "/");
//		filePath = filePath.replace("/", File.separator).replace("\\", File.separator);

		File file = new File(filePath, convertFileName);

		// try catch로 예외 처리 안해줄 시 컴퓨터가 어떻게 할지 몰라서 필수로 해주기
		try {
			// file 물리저장
			multipartFile.transferTo(file);

			// filePath DB 저장
			fileDTO.setFileName(convertFileName);
			fileDTO.setOriginalFileName(originalFileName);
			fileDTO.setFilePath(filePath);

			employeeRepository.updateFileInfo(fileDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void retiredUserInfo(Long userNo) {
		employeeRepository.updateFromDate(userNo);
	}

	public List<EmployeeDTO> findAllEmployee() {
		return employeeRepository.findAll();
	}

	public List<EmployeeDTO> findAllByName(String name) {
		return employeeRepository.findAllByName(name);
	}

	public List<EmployeeDTO> findAllByUserNo(Long userNo) {
		return employeeRepository.findAllByUserNo(userNo);
	}

	public List<EmployeeDTO> findAllByDeptName(String deptName) {
		return employeeRepository.findAllByDeptName(deptName);
	}

	// paging
	public List<EmployeeDTO> findAllEmployeePaging(Paging paging) {
		return employeeRepository.findAllPaging(paging);
	}

	public List<EmployeeDTO> findAllByNamePaging(String name, Paging paging) {
		return employeeRepository.findAllByNamePaging(name, paging);
	}

	public List<EmployeeDTO> findAllByUserNoPaging(Long userNo, Paging paging) {
		return employeeRepository.findAllByUserNoPaging(userNo, paging);
	}

	public List<EmployeeDTO> findAllByDeptNamePaging(String deptName, Paging paging) {
		return employeeRepository.findAllByDeptNamePaging(deptName, paging);
	}

}