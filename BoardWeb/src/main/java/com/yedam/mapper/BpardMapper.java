package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

//import com.yedam.vo.BoardVO;

/*인터페이스 - XML 매칭.*/

/*인터페이*/
public interface BpardMapper {
	public List <BoardVO> selectList();
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
}
