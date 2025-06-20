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
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//한글처리.
		req.setCharacterEncoding("utf-8");
		
		//요청방식 (GET/ POST)구분 처리.
		if(req.getMethod().equals("GET")) {
			//WEB-INF/jsp/addBoard.jsp ->실페이지는 addBpard.do
			//getRequestDispatcher현재이페이지에서("")매개값페이지로재지정하겠습니다.,현재페이지는 add~ url값을 WEB-INF/jsp/addBoard.jsp(경로) -> frontcontrol가 제어하기위해 이리함
			req.getRequestDispatcher("user/addBoard.tiles").forward(req, resp);
			//dispatcher없을시 addboard.do에 머물러있는상태,forward메소드가 실제페이지이동하게해줌
		}else if(req.getMethod().equals("POST")) { //글 등록(한건 db)
			//POST요청
			//url치고누르거나 get,post폼태그안매소드이용,ajax
			String title = req.getParameter("title");//파라미터->boardService전달
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
				//sendRedirect응답결과를 이화면이 아닌 ""페이지에 재지정
				resp.sendRedirect("boardList.do");
			}else {
				System.out.println("등록실패");
			}
		}//end of if
		

	}//end of exec.

}//end of class.
