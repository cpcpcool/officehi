package com.groupware.officehi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NoticeDTO {
	private Long notice_no;
    private String date;
	private String content;
	private String fieldPath;
	private String title;

	public NoticeDTO (Long notice_no, String content, String date, String title) {
		this.notice_no = notice_no;
		this.content = content;
		this.date = date;
		this.title = title;
	}
}
