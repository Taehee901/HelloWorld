package com.yedam.control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//한글처리.
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//요청방식 (GET/ POST)구분 처리.
		if(req.getMethod().equals("GET")) {
			//WEB-INF/jsp/addBoard.jsp ->실페이지는 addBpard.do
			//getRequestDispatcher현재이페이지에서("")매개값페이지로재지정하겠습니다.
			try {
				req.getRequestDispatcher("WEB-INF/jsp/addBoard.jsp").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(req.getMethod().equals("POST")) { //글 등록
			//POST요청
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
//				resp.sendRedirect("servlet/boardList.serv");
			}else {
				System.out.println("등록실패");
			}
		}//end of if
		

	}//end of exec.

}//end of class.
