package com.groupware.officehi.dto;

import com.groupware.officehi.domain.Paging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 박재용
 * @editDate 23.12.24 ~23.12.25
 */

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PagingDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int pageNum = new Paging().getPageNum();
	private int amount = new Paging().getAmount();
	
	private int total;
	private Paging paging;

	public PagingDTO(Paging paging, int total) {
        this.paging = paging;
        this.total = total;
        
        this.endPage = (int)(Math.ceil(paging.getPageNum()/10.0)) * 10;
        this.startPage = this.endPage - 9;
        
        int realEnd = (int)(Math.ceil((total * 1.0) / paging.getAmount()));
        
        if(realEnd < this.endPage) {
            this.endPage = realEnd;
        }
        
        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
