package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 규칙,서비스를통해메소드호출하게하려고,나중에 db나 뭐 변경할 시,메소드이름 동일하게하기위해서
 * 업무 단위의 처리.
 * 
 * */
public interface BoardService {
	public List<BoardVO> boardList();//목록조회.
	public BoardVO getBoard(int bno);//단건조회.
	public boolean registerBoard(BoardVO board);//등록기능,필요할경우 값변경해주면됨,
	
}
