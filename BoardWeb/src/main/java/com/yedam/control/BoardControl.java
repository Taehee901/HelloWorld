package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	//예외처리 넘김
	public void exec(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
//		System.out.println("글상세");
		//http://localhost:8080/board.do?(?뒤에는 파라미터)bno=34 단건조회
		String bno = req.getParameter("bno");//=뒷부분받아와서 글에대한정보봄bno지정
		//boardList와 코드흐름비슷
		//글상세조회
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(bno));//문자열 -> int파싱,조회 주소값가짐
		//요청정보저장
		//주소값을읽어오려면 getAttribute
		req.setAttribute("board", board);
		
		//요청재지정(페이지이동)
 		req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
		
	}
	
}
