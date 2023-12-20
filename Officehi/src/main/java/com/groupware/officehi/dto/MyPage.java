package com.groupware.officehi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MyPage {
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
	
	public MyPage(Long userNo, String name, String toDate, 
			String fromDate, String birthDate, String phone, String stamp,
			String profile, String position, String deptName) {
		this.userNo = userNo;
		this.name = name;
		this.toDate = toDate;
		this.fromDate = fromDate;
		this.birthDate = birthDate;
		this.phone = phone;
		this.stamp = stamp;
		this.profile = profile;
		this.position = position;
		this.deptName = deptName;
	}
}
