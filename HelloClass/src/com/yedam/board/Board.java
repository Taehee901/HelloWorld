package com.yedam.board;

//글번호,제목,내용,작성자: 필드.
//getter,setter작성.
//기본생성자,전체매개값을 갖는 생성자
public class Board {
	private int boardNo;//글번호.
	private String title;//제목.
	private String content;//내용.
	private String writer;
	//생성자.
	public Board() {}//기본생성자
	
	public Board(int boardNo,String title,String content,String writer) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	//bordeExe
	//글번호,제목,작성자 => 간략하게보여주는
	public void showInfo() {
		//1     날씨가 좋아요    홍길동
		System.out.printf("%3d %12s %4s\n",boardNo,title,writer);
	}
}
