package com.groupware.officehi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class NoticeDTO {
	
	private Long noticeNo;
    private String date;
	private String content;
	private String title;

}
