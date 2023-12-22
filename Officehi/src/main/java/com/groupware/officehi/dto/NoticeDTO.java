package com.groupware.officehi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NoticeDTO {
	private Long noticeNo;
    private String date;
	private String content;
	private String title;

	public NoticeDTO(Long noticeNo, String content, String date, String title) {
		this.noticeNo = noticeNo;
		this.content = content;
		this.date = date;
		this.title = title;
	}

	public NoticeDTO() {
	}
}
