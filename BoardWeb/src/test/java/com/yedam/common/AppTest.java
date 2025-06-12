package com.yedam.common;

import java.util.List;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

//run as = java.application
public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		
		//입력.,매개값으로 ReplyVO,오타오류
//		ReplyVO rep = new ReplyVO();
//		rep.setBoardNo(221);
//		rep.setReply("댓글연습입니다.");
//		rep.setReplyer("newbie");
//		
		//svc.addReply(rep);//등록기능,기능확이하려면따라가,여러반복
		
		//삭제,댓글번호
//		svc.removeReply(7);
		
		//목록
		//커밋안해서 1건만 조회되었음.+ bno->rno쪽에 넣어놔서 에러뜸(바보짓을했다.)
//		List<ReplyVO> list = svc.replyList(221);//원본글번호넣으면 원본글에 해당되는 댓글목록들을 반환해줌
//		for(ReplyVO reply : list) {
//			System.out.println(reply.toString());
//		}
//		
		//한건조회,댓글번호기준,상세정보
//		ReplyVO reply = svc.getReply(3);
//		System.out.println(reply.toString());
			
		
		
//		svc.removeReply(8);
		
		
		
		
		
		
		
		
		
		
		
	}
}
