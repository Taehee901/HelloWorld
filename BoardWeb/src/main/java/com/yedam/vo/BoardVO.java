package com.yedam.vo;

import java.util.Date;

import lombok.Data;

/*
 * 필드,생성자,메소드(getter,setter)만드는 부분
 * 이클립스의 source사용x
 * lombok 라이브러리 사용(설치,라이브러리),그러면 필드만 선언하면 됨
 * 
 * */
//어노테이션방식-직접다 입력x,이러면 필드만 작성하면 알아서 만들어줌,필요한기능 추가
//@Getter
//@Setter
//@NoArgsConstructor //기본생성자

//boarderMapper resultType의 데이터타입 편하게만들려고

//한번에
//@AllArgsConstructor //전체매개값가지는 생성자
@Data //해시코드,생성자,toString..등 알아서 만들어줌,전체생성자는 안만들어줌
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int readCnt;
	
}
