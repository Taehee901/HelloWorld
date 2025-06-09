package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//한글처리.
		//요청방식에 따라 GET요청이면 화면open.
		//			 POST요청이면 저장.
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardService svc = new BoardServiceImpl();
		
		if(req.getMethod().equals("GET")) {
			//요청재지정(페이지이동) modifyBoard.do?bno=23
			//단건조회
			BoardVO board = svc.getBoard(Integer.parseInt(bno));//조회하기위한기능
			req.setAttribute("board", board);//값읽어들임,사용자입력값데이터전달
	 		//만든페이지만재정의가능
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
		}
		else if(req.getMethod().equals("POST")) {
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			
			svc.modifyBoard(board);//수정
			
	//목록페이지로 이동.,sendRedirect와 getRequestDispatcher 포워딩 차이 - 파라미터를 attribute담아전달,단순페이지보여줄때는 send,정보보여주고싶으면 re
			//외부사이트로도재정의가능
			resp.sendRedirect("boardList.do");
		}

	}

}
