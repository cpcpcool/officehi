package com.groupware.officehi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 박재용
 * @editDate 23.12.20 ~ 23.12.22
 * 페이지네이션 기능 추가 23.12.23 ~ 23.12.25
 */

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EmployeeDTO {
	
	private Long userNo;
	private String name;
	private String phone;
	private String birthDate;
	private String toDate;
	private String fromDate;
	private String position;
	private String profile;
	private String stamp;
	private String deptName;
	
}
