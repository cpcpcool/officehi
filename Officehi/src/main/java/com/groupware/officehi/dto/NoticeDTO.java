package com.groupware.officehi.dto;
/**
 * @author 정유진
 * @editDate 23.12.18 ~23.12.26
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class NoticeDTO {
	
	private Long noticeNo;
	private String title;
    private String date;
	private String content;

}
