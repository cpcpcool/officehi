package com.groupware.officehi.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 박재용
 * @editDate 23.12.20 ~ 23.12.22 페이지네이션 기능 추가 23.12.23 ~ 23.12.25
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

	private Long userNo;

	@NotEmpty(message = "이름을 입력해주세요")
	private String name;

	@NotEmpty(message = "전화번호를 입력해주세요")
	private String phone;
	
	@NotEmpty(message = "생년월일을 입력해주세요")
	private String birthDate;
	
	@NotEmpty(message = "입사일을 선택해주세요")
	private String toDate;
	
	@NotEmpty(message = "부서명을 입력해주세요")
	private String deptName;
	
	private String fromDate;
	
	private String position;
	
	private String profile;
	
	private String stamp;
	
}
