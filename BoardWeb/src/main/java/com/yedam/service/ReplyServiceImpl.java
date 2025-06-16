package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;
//구현클래스,service추상클래스
public class ReplyServiceImpl implements ReplyService {

	SqlSession sqlsession = DataSource.getInstance().openSession();
	ReplyMapper repl = sqlsession.getMapper(ReplyMapper.class);
	@Override
	public boolean addReply(ReplyVO rvo) {
		//댓글입력처리
		int r = repl.insertReply(rvo);
		if(r == 1) {
			sqlsession.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<ReplyVO> replyList(int bno,int page) {
		// TODO Auto-generated method stub
		return repl.selectList(bno,page);
	}

	@Override
	public ReplyVO getReply(int rno) {
		// TODO Auto-generated method stub
		return repl.getReply(rno);
	}
	
	//댓글삭제
	@Override
	public boolean removeReply(int rno) {
		// TODO Auto-generated method stub
		int r = repl.delectReply(rno);
		if(r==1) {
			sqlsession.commit();
			return true;
		}
		return false;
	}

	@Override
	public int totalCount(int bno) {
		return repl.selectTotal(bno);
	}


}
