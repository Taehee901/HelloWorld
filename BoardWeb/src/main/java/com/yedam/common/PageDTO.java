package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
// 게시글 건수 -> 페이지 계산.
	//필드를 한번에 여러개 지정가능
	//start 현페이지기준 n1 end n0
	private int start,end,currentPage;
	private boolean prev,next;
	
	//생성자호출매개값,전체건수
	public PageDTO(int page,int totalCnt) {
		this.currentPage = page; //현재페이지 3page
		this.end = (int)Math.ceil(1.0 * page/10) * 10;//ceil올림,현재페이지기준으로 - 0.3 올림하면 1 --> 10
		this.start = this.end - 9;// 1
		
		//실체페이지마지막
		//건수를 기준으로 실제 마지막페이지.
		int realEnd = (int)Math.ceil(1.0*totalCnt/5);//실제페이지 마지막가나올거다,64page
		this.end = this.end > realEnd ? realEnd : this.end;
		
		//이전,이후 페이지의 존재 체크.
		//1이 아닐경우 prev가 출력되게
		this.prev = this.start > 1;//11,21....
		this.next = this.end< realEnd;//end마지막페이지가 실제계산페이지보다 작을경우,이후페이지 활성화
	}
}
