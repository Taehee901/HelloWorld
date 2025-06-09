package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
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
		//원본 boardList.do?page=2
		//페이지를 활용해서 전달하려한다 - int타입변환필요
		String page = req.getParameter("page");
		page = page == null ? "1" : page;// boardList.do =>1페이지 출력.
		BoardService svc = new BoardServiceImpl();
		//페이지정보가들어가야함
		List<BoardVO> list = svc.boardList(Integer.parseInt(page));//목록가져오는기능
		
		//페이징 계산
//		int totalCnt = 112;
		int totalCnt = 320;
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		
		
		//요청정보에 값을 담아서 전달,jsp로
		req.setAttribute("blist", list); //요청정보에담아서(req) jsp로 전달
		req.setAttribute("pageInfo", paging);
		//요청재지정(페이지이동)
 		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
			

	}

}
