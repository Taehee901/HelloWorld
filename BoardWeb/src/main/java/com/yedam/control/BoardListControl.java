package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
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
		//boardList.do?page=2&searchCondition=W&keyword=guest ->0630
		//페이지를 활용해서 전달하려한다 - int타입변환필요
		String page = req.getParameter("page");
		page = page == null ? "1" : page;// boardList.do =>1페이지 출력.
		String sc = req.getParameter("searchCondition");
		//키워드 값도 가져워야함
		String kw = req.getParameter("keyword");
		//검색조건.
		SearchDTO search = new SearchDTO();
		//페이지값
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		//키워드담김값을 search다시담음
		search.setKeyword(kw);
		//데이터처리.
		//페이지정보가들어가야함		
		BoardService svc = new BoardServiceImpl();
		//인터페이스타입,boardlist변경필요
		//파라미터 다수를 넣는것보다변수선언하는게 더 나음
		List<BoardVO> list = svc.boardList(search); //searchDTO타입
//		List<BoardVO> list = svc.boardList(Integer.parseInt(page));//목록가져오는기능,파라미터가많아지면관리힘듦
		
		//페이징 계산 - 임의로
//		int totalCnt = 112;
//		int totalCnt = 320;
		int totalCnt = svc.getTotalCount(search);
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		
		//jsp페이지에 정보전달
		//요청정보에 값을 담아서 전달,jsp로
		//파라미터로읽어올지 Attrubute에 담을지
		req.setAttribute("blist", list); //요청정보에담아서(req) jsp로 전달
		req.setAttribute("pageInfo", paging);
		req.setAttribute("search", search);
		//요청재지정(페이지이동)
 		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
	}

}
