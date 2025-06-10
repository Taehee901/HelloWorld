package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

//import com.yedam.vo.BoardVO;

/*인터페이스 - XML 매칭.*/

/*인터페이스*/
public interface BoardMapper {
	public List<BoardVO> selectList();//목록 . 사용x
//	public List<BoardVO> selectListWithPaging(int page);
	public List<BoardVO> selectListWithPaging(SearchDTO search);
	public BoardVO selectBoard(int bno);//단건조회,처리건수 반환하는걸로 정해져있음,resulttype따로 선언x
	public int updateReadCnt(int bno);//조회 count증가
	public int insertList(BoardVO board);//처리결과 int
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
	//전체건수.
//	public int selectCount();
	public int selectCount(SearchDTO search);//sqp 쿼리에서 int이기에 int타입씀
}
