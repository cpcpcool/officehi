package com.groupware.officehi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 박재용
 * @editDate 23.12.24 ~23.12.25
 */

@Getter @Setter
@AllArgsConstructor
public class Paging {

	private int pageNum; // 페이지번호
	private int amount;	// 몇 개 데이터 보여줄지
	
	public Paging() {
		this(1,10);
	}
	
	// mapper에서 사용
	public int getOffset() {
		 return (pageNum - 1) * amount;
	}
	
}
