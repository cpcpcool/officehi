package com.groupware.officehi.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Notice {
	private Long notice_no;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
	private String content;
	private String fieldPath;
	private String title;

	public Notice(Long notice_no, String content) {
		this.notice_no = notice_no;
		this.content = content;
		this.date = date;
		this.title = title;
	}
}
