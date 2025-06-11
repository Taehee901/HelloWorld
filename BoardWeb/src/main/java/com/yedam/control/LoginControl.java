package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO id,pw 활용->로그인
		String id = req.getParameter("mid");
		String pw = req.getParameter("pass");
		
		//로그인
		MemberService svc = new MemberServiceImpl();
		MemberVO member  = svc.login(id, pw);//조회기능
		//성공여부 체크.,아이디 !null DBo
		if(member != null) {
			//글등록 화면.
			//세션객체에 setAttribute("logId",member.memberID),getsesstion
			//세션객체에 setAttribute("logId",member.memberID)
			//요청정보값읽어와서 쿠키~? 각브라우저마다 다른세션으로 인식,브라우저와서버 정보 비교해서 세션에 임의의값박아넣음,세션을 지우거나 자동사라지면 attrubyte다시 읽어와도 session값으로는 로그인 처리할수없구나 인식30기본 지나면 reset
			//세션 어느객체에서든 접근가능
			HttpSession session =  req.getSession();//서버 페이지요청 쿠키를 웹 페이지에 정보를 하나 심어둠
			session.setAttribute("logId", member.getMemberId());//session은 일정시간이 지나거나 초기화 생명주기,request는 한번생성하고 보여주면 사라짐
			//권한에 따라 시작페이지지정.
			if(member.getResponsibility().equals("User")) {
				resp.sendRedirect("addBoard.do");				
			}else if(member.getResponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");	
			}
			//cookie
			//웹브라우저에
		}else {
			//로그인화면으로 이동.
			req.setAttribute("msg", "ID와 PW를 확인하세요.");
			req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
		}
	}

}
