package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글삭제. rno필요
		String rno = req.getParameter("rno");
		
		//DB입력처리.
		ReplyService svc = new ReplyServiceImpl();
		//DB 한건입력,매개값으로 전달되어야함
		if(svc.removeReply(Integer.parseInt(rno))) {
			//{"retCode": "Success"},json문자열
			resp.getWriter().print("{\"retCode\": \"Success\"}");
		}else {
			//{"retCode": "Fail"}
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}

	}

}
