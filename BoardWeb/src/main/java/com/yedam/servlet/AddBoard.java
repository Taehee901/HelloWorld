package com.yedam.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//init,메소드하는역할없으면 서비스만만들어도된다.
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

@WebServlet("/addBoard.serv")//주소입력시,boardservice출력
public class AddBoard extends HttpServlet {
	//http 메소드를 받는걸 선택
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//addBoard.serv?title=제목&content=내용&writer=user01
		//&두개이상일때,req.getParameter파라미터이름적어주면 = 뒤에거 반환해줌
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		//메소드의 매개값을 전달하기 위해서.
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		//업무 서비스
		BoardService svc = new BoardServiceImpl();
		if(svc.registerBoard(board)){//한건등록
			System.out.println("등록성공");
			//목록페이지로 이동
			//sendRedirect현재페이지에서 새페이지로 이동
			resp.sendRedirect("servlet/boardList.serv");
		}else {
			System.out.println("등록실패");
		}
		//node-spring
	}
}
