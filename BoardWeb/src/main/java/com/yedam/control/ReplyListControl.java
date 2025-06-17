package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ReplyList.do => json문자열 반환.(직접만들수있지만귀찮..라이브러리추가)
		//자바객체 -> json 문자열로 변환(Gson)
		//클래스타입 자바객체
		resp.setContentType("text/json;charset=utf-8");
		
		String bno = req.getParameter("bno");//게시글번호알려주면댓글번호,파라미터로 
		String page = req.getParameter("page");
		page="1";//null에러 방지
//		ReplyVO reply = new ReplyVO();
//		reply.setBoardNo(221);
//		reply.setReply("댓글내용");
//		reply.setReplyer("user01");
		
		//여러건가져오는 
		
		ReplyService svc = new ReplyServiceImpl();
		//List<ReplyVO> list = svc.replyList(Integer.parseInt(bno),Integer.parseInt(page));//파라미터를통해받음
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno),Integer.parseInt(page));
		//데이터안에 리스트 넣음
		//DataTable용.
		Map<String, Object> map = new HashMap<>();
		map.put("data", list);
		
		//GsonBuilder gson객체 받아옴, tojson reply(ReplyVO)자바객체를 json문자열로바꾸어줌
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(reply);
		//String json = gson.toJson(list);
		String json = gson.toJson(map);
		System.out.println(json);
		
		PrintWriter out = resp.getWriter();
		out.print(json);
		
	}

}
