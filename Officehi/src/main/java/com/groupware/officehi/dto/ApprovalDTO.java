package com.groupware.officehi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	private String checker1;
	
}