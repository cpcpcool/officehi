package com.groupware.officehi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
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
