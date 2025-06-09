package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService{
	SqlSession sqlSession = DataSource.getInstance().openSession();
	//데이터베이스처리기능 mapper담김
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardList() {
		// TODO Auto-generated method stub
		return mapper.selectList();
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


}
