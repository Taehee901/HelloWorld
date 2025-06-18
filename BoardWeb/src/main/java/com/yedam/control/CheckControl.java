package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class CheckControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aaaaaa.do?id=user01,req.getpar
		String user = req.getParameter("id");
		MemberService svc = new MemberServiceImpl();
		if(svc.getMemberInfo(user)) {
			resp.getWriter().print("{\"retCode\":\"Exist\"}");//{"retCode": "Exist"},이클립스가 이니스프
		}else {
			resp.getWriter().print("{\"retCode\":\"NotExist\"}");
		}
	}

}
