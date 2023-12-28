package com.groupware.officehi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author 정유진
 * @editDate 23.12.19 ~ 23.12.20
*/

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MyPageDTO {
	
	private Long userNo;
	private String name;
	private String toDate;
	private String fromDate;
	private String birthDate;
	private String phone;
	private String stamp;
	private String profile;
	private String position;
	private String deptName;
	
}
