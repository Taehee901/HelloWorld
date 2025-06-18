package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

public class BoardServiceImpl implements BoardService{
	SqlSession sqlSession = DataSource.getInstance().openSession();
	//데이터베이스처리기능 mapper담김
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	@Override
	public List<BoardVO> boardList(SearchDTO search) {
		// TODO Auto-generated method stub
//		return mapper.selectList();
		//return mapper.selectListWithPaging(search);
		return mapper.selectList();//전체건수로 페이징나눠
	}

	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		BoardVO board = mapper.selectBoard(bno);//글번호 기준으로 ->조회
		if(board != null) {
			mapper.updateReadCnt(bno);//글번호 해당되는 -> 조회수 증가
			sqlSession.commit();//커밋처리
		}
		return board;
	}
//registerBoard는
	@Override
	public boolean registerBoard(BoardVO board) {
		 int r = mapper.insertList(board);//처리된 건수 
		 //어떤경우에는 커밋,롤백을 할 필요가 있음
		 if(r == 1) {
			 sqlSession.commit();//커밋처리
			 return true;
		 }
		 return false; //숫자int 1와 같으면 정상값 boolean 선언
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		int r = mapper.updateBoard(board);
		if(r == 1) {
			 sqlSession.commit();//커밋처리
			 return true;
		}
		return false;
	}

	@Override
	public BoardVO removeBoard(int bno) {
		BoardVO board = mapper.selectBoard(bno);//글번호 기준으로 ->조회
		if(board != null) {
			mapper.deleteBoard(bno);//글번호 해당되는 -> 조회수 증가
			sqlSession.commit();//커밋처리
		}
		return board;
	}

	@Override
	public int getTotalCount(SearchDTO search) {
		return mapper.selectCount(search);
	}

	@Override
	public List<Map> chartCount() {
		// TODO Auto-generated method stub
		return mapper.selectUserByCount();
	}

	@Override
	public List<Map<String,String>> eventList() {
		// TODO Auto-generated method stub
		return mapper.selectEvent();
	}

	@Override
	public boolean addEvent(EventVO evo) {
		// TODO Auto-generated method stub
		int r = mapper.insertEvent(evo);
		if(r == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeEvent(Map<String, String> map) {
		// TODO Auto-generated method stub
		int r = mapper.deleteEvent(map);
		if(r == 1) {
			return true;
		}
		return false;
	}



}
