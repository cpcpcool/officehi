package com.groupware.officehi.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Alias("ApprovalDTO")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ApprovalDTO {
	
	private Long approvalNo;
	private Long userNo;
	private String date;
	private String title;
	private String content;
	private Integer status;
	private String category;
	private String checkDate;
	private String checker1;
	
	@Getter @Setter
	@NoArgsConstructor @AllArgsConstructor
	public static class ApprovalListDTO {
		private String userName;
		private Long approvalNo;
		private String title;
		private String deptName;
		private String date;
		private String checkDate;
	}
	
	@Getter @Setter
	@NoArgsConstructor @AllArgsConstructor
	public static class ApprovalSaveDTO {
		private Long userNo;
		private Long approvalNo;
		private String title;
		private String content;
		private String category;
		private String checker1;
	}
	
	@Getter @Setter
	@NoArgsConstructor @AllArgsConstructor
	public static class ApprovalUserList {
		private Long userNo;
		private String name;
		private String deptName;
	}
	
}

/*
private Long approvalNo;
private Long userNo;
private String date;
private String title;
private String content;
private Integer status;
private String checkDate;
private Long checker1;
private Long checker2;
private Long checker3;
*/