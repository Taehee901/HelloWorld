package com.yedam.mapper;

import com.yedam.vo.BoardVO;

/*인터페이스 - XML 매칭.*/

/*인터페이*/
public interface BpardMapper {
	public BoardVO selectBoardVO();
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
}
