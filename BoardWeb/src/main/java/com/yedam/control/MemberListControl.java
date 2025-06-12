package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//정렬순서(order)
		//memberlist.do?order로 파라미터넘,mbmberList전달긴다고했음,컨트롤해줘야함
		String order = req.getParameter("order");
		order = order == null ? "member_id" : order;//기준 정렬은 id정렬.
		MemberService svc = new MemberServiceImpl();
		//반환데이터타입 
		List <MemberVO> list = svc.memberList(order);
		req.setAttribute("memberList", list);
		//출력jsp
		//jsp-member-memberL
//		req.getRequestDispatcher("WEB-INF/jsp/member/memberList.jsp").forward(req, resp);
		req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);
	}

}
