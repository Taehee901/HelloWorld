package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

/*
 * 규칙,서비스를통해메소드호출하게하려고,나중에 db나 뭐 변경할 시,메소드이름 동일하게하기위해서
 * 업무 단위의 처리.
 * 
 * */
public interface BoardService {
//	public List<BoardVO> boardList(int page);//목록조회.
	public List<BoardVO> boardList(SearchDTO search);//목록조회.
	public BoardVO getBoard(int bno);//단건조회.
	public boolean registerBoard(BoardVO board);//등록기능,필요할경우 값변경해주면됨,
	public boolean modifyBoard(BoardVO board);//수정기능
	public BoardVO removeBoard(int bno);//삭제기능
	// 전체카운트 계산.
//	public int getTotalCount();
	public int getTotalCount(SearchDTO search);//매퍼쪽:selectCount()
	public List<Map> chartCount();
	//tbl_event
	public List<EventVO>eventList();
	public boolean addEvent(EventVO evo);
	public boolean removeEvent(EventVO evo);
	//public boolean removeEvent(EventVO evo);
}
