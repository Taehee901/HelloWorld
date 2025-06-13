package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
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

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글등록. 원본글번호,댓글작성자,댓글내용
		req.setCharacterEncoding("utf-8");//요청정보에 한글포함되어있으면 인코딩방식을지정해줘야함
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");//원본글번호
		String reply = req.getParameter("reply");//댓글내용
		String replyer = req.getParameter("replyer");//댓글작성자
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		//json문자열 생성 함수
		Map<String,Object> map = new HashMap<>();
		//코드가무슨값으로되어잇는지확인필요
		Gson gson = new GsonBuilder().create();
		//DB입력처리.
		ReplyService svc = new ReplyServiceImpl();
		//DB 한건입력,매개값으로 전달되어야함
		if(svc.addReply(rvo)) {
			//{"retCode": "Success"},json문자열
			//resp.getWriter().print("{\"retCode\": \"Success\"}");
			map.put("retVal", rvo);
			map.put("retCode", "Success");
		}else {
			//{"retCode": "Fail"}
			map.put("retCode", "Fail");
			//resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
		String json = gson.toJson(map);//파싱,map을 json문자열로
		System.out.println(json);
		resp.getWriter().print(json);//반환
	}

}
