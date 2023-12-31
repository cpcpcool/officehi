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

	private int pageNum;
	private int amount;
	
	public Paging() {
		this(1,10);
	}
	
	public int getOffset() {
		 return (pageNum - 1) * amount;
	}
	
}

