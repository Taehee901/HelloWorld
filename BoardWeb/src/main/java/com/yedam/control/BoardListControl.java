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

public class BoardListControl implements Control{

	//req
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		System.out.println("글목록");
//		req.setAttribute("myName", "Hongkildong");
		//글목록전달
		//list객체주소값참조변수
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList();//목록가져오는기능
		//요청정보에 값을 담아서 전달,jsp로
		req.setAttribute("blist", list); //요청정보에담아서(req) jsp로 전달
		
		//요청재지정(페이지이동)
 		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
			

	}

}
