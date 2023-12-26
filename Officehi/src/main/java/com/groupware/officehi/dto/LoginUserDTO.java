package com.groupware.officehi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* @author 이승준
* @editDate 23.12.18 ~ 23.12.20
*/

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class LoginUserDTO {
	
	private Long userNo;
	private String pw;
	private int admin;
	
}
