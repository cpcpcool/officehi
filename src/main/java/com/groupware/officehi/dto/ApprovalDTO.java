package com.groupware.officehi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 엄다빈
 * @editDate 23.12.18 ~ 23.12.26
 */

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ApprovalDTO {
	
	private Long approvalNo;
	private Long userNo;
	private String name;
	private String deptName;
	private String date;
	private String title;
	private String content;
	private Integer status;
	private String category;
	private String checkDate;
	private String position;
	
	@Getter @Setter
	@NoArgsConstructor @AllArgsConstructor
	public static class Checker {
		private Long approvalNo;
		private Integer checkerNo;
		private Integer confirm;
		private Long userNo;
	}
}