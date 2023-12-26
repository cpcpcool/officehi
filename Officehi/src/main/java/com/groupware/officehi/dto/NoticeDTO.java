package com.groupware.officehi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 정유진
 * @editDate 23.12.18 ~ 23.12.19
 */

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class NoticeDTO {
	
	private Long noticeNo;
	private String title;
    private String date;
	private String content;

}
