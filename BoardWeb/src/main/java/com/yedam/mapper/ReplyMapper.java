package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

//update,insert,delete 
public interface ReplyMapper {
	public int insertReply(ReplyVO rvo);
	public List<ReplyVO> selectList(int bno); 
	public ReplyVO getReply(int rno);//단건조회
	public int delectReply(int rno);
}
