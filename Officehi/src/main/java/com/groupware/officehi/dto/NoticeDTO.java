package com.groupware.officehi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 정유진
 * @editDate 23.12.18 ~ 23.12.19
 */

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class NoticeDTO {
	private Long noticeNo;
    private String date;
	private String content;
	private String title;
}
